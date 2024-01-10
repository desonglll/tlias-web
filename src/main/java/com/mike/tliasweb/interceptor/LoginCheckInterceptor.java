package com.mike.tliasweb.interceptor;


import com.alibaba.fastjson.JSONObject;
import com.mike.tliasweb.entity.Result;
import com.mike.tliasweb.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liwei
 * @date 2023/11/28
 */
@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {


    /**
     * 目标方法执行之前进行调用
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.获取到token
        String token = request.getHeader("token");
        log.info("获取到token:{}", token);
        //2.判断token有没有  如果没有,说明没有登录,不让他继续访问接口,并且返回错误信息,前端跳转到登录界面
        if (!StringUtils.hasLength(token)) {
            log.info("token不存在");
            //创建响应结果对象
            Result responseResult = Result.error("NOT_LOGIN");
            //把Result对象转换为JSON格式字符串 (fastjson是阿里巴巴提供的用于实现对象和json的转换工具类)
            String json = JSONObject.toJSONString(responseResult);
            //设置响应头（告知浏览器：响应的数据类型为json、响应的数据编码表为utf-8）
            response.setContentType("application/json;charset=utf-8");
            //响应
            response.getWriter().write(json);

            return false;//不放行

        }
        //3.token有了,解析token 判断token是否合法 如果合法就放行,允许访问后端接口 如果不合法,不让他继续访问接口,并且返回错误信息,前端跳转到登录界面

        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            Result responseResult = Result.error("NOT_LOGIN");
            //把Result对象转换为JSON格式字符串 (fastjson是阿里巴巴提供的用于实现对象和json的转换工具类)
            String json = JSONObject.toJSONString(responseResult);
            //设置响应头（告知浏览器：响应的数据类型为json、响应的数据编码表为utf-8）
            response.setContentType("application/json;charset=utf-8");
            //响应
            response.getWriter().write(json);

            return false;//不放行
        }

        return true;
    }

    /**
     * 目标方法执行完成之后
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 视图渲染完毕之后调用
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
