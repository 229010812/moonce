package com.moonce.blog.web;

import com.moonce.blog.service.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

@Configuration
public class InitLoader implements ApplicationListener<ContextRefreshedEvent> {
    private OptionsService optionsService;

    @Autowired
    public void setOptionsService(OptionsService optionsService) {
        this.optionsService = optionsService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        optionsService.initConfig();
        // TODO: 2018/8/8 redis缓存数据库数据
    }
}
