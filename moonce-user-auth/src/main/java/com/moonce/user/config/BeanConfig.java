package com.moonce.user.config;

import com.moonce.user.util.IdWorker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Value("${snowflake.worker-id}")
    private  long  workerId = 0;
    @Value("${snowflake.data-center-id}")
    private  long  dataCenterId = 0 ;

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(workerId,dataCenterId);
    }
}
