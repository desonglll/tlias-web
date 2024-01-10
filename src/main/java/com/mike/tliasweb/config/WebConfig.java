package com.mike.tliasweb.config;


import com.mike.tliasweb.interceptor.LoginCheckInterceptor;
import com.mike.tliasweb.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author liwei
 * @date 2023/11/28
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginCheckInterceptor)
                // 要拦截的路径
                .addPathPatterns("/*")
                //不拦截的路径
                .excludePathPatterns("/login");
    }
}
