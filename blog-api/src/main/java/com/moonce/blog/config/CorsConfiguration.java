package com.moonce.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 跨域处理
 */
@Configuration
public class CorsConfiguration extends WebMvcConfigurerAdapter{
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")//请求路径
                        .allowedOrigins("http://moonce.com", "http://localhost")//请求域名
                        .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS")//请求方法
                        .allowCredentials(false).maxAge(3600);
            }

}
