package com.moonce.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CorsConfiguration extends WebMvcConfigurerAdapter{
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://moonce.com", "http://localhost")
                        .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS")
                        .allowCredentials(false).maxAge(3600);
            }

}
