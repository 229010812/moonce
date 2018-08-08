package com.moonce.test;

import com.moonce.MoonceApplication;
import com.moonce.blog.service.UserService;
import com.moonce.repository.UserRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = MoonceApplication.class)
public class UserTest {
    @Resource
    private UserRepository userRepository;
    @Resource
    private UserService userService;

    @Test
    @Ignore
    public void addUser(){
//        userService.addUser();
    }
}
