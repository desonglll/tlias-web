package com.mike.tliasweb.controller;

import com.mike.tliasweb.entity.Emp;
import com.mike.tliasweb.entity.Result;
import com.mike.tliasweb.service.EmpService;
import com.mike.tliasweb.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: mikeshinoda
 * @date: 2024/1/10
 * @description:
 */
@RestController
public class LoginController {
    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        Emp loginEmp = empService.login(emp);
        //判断：登录用户是否存在
        if (loginEmp != null) {
            //自定义信息
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", loginEmp.getId());
            claims.put("username", loginEmp.getUsername());
            claims.put("name", loginEmp.getName());

            //使用JWT工具类，生成身份令牌
            String token = JwtUtils.generateJwt(claims);
            return Result.success(token);
        }
        return Result.error("用户名或密码错误");
    }
}
