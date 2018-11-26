package com.moonce.blog.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
public class RedisConfig {

    @Bean("strKeyRedisTemplate")
    public RedisTemplate<Object,Object> strKeyRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object,Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        RedisSerializer<String> stringRedisSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringRedisSerializer);
        return template;
    }

    @Bean("jsonRedisTemplate")
    public RedisTemplate<Object,Object>  redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<Object,Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }

    @Bean("jsonRedisTemplate")
    public RedisTemplate<Object,Object>  redisTemplate(RedisConnectionFactory redisConnectionFactory, ObjectMapper mapper){
        RedisTemplate<Object,Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer(mapper));
        return template;
    }
}
