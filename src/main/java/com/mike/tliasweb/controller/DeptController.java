package com.mike.tliasweb.controller;

import com.mike.tliasweb.entity.Dept;
import com.mike.tliasweb.entity.Result;
import com.mike.tliasweb.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: mikeshinoda
 * @date: 2024/1/5
 * @description:
 */
//部门管理控制器
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 查询所有数据
     *
     * @return
     */
    //@RequestMapping(value = "/depts" , method = RequestMethod.GET)
    @GetMapping
    public Result list() {
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

//    @GetMapping
//    public Result getAll() {
//        List<Dept> list = deptService.getAll();
//        return Result.success(list);
//    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable int id) {
        System.out.println(id);
        int result = deptService.deleteById(id);
        if (result == 1)
            return Result.success(null);
        return Result.error("failed to delete");
    }

    @PostMapping
    public Result add(@RequestBody Dept dept) {
        int result = deptService.add(dept);
        if (result == 1)
            return Result.success(null);
        return Result.error("failed to add");
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable int id) {
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept) {
        int result = deptService.update(dept);
        if (result == 1)
            return Result.success(null);
        return Result.error("failed to update");
    }

}
