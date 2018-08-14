package com.moonce.test;

import com.moonce.MoonceApplication;
import com.moonce.doman.User;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = MoonceApplication.class)
public class TestRedis {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    /**
     * 通过StringRedisTemplate存取简单字符串
     * 包含字符串的数据结构
     */
    @Test
    @Ignore
    public void setStrValueByStringRedisTemplate(){
        stringRedisTemplate.opsForValue().set("test-key","test value");
        System.out.println(stringRedisTemplate.opsForValue().get("test-key"));
    }

    /**
     * 通过RedisTemplate存取对象
     * JDK序列化策略
     */
    @Test
    public void setObjectByRedisTemplate(){
        User user = new User();
        user.setTel("18896539969");
        user.setEmail("229010812@qq.com");
        redisTemplate.opsForValue().set("user",user);
        User user1 = (User) redisTemplate.opsForValue().get("user");
        System.out.println(user1.toString());
    }


}
