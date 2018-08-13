package com.moonce.test;

import com.moonce.MoonceApplication;
import com.moonce.blog.service.UserService;
import com.moonce.doman.User;
import com.moonce.repository.UserRepository;
import com.moonce.util.CommonUtils;
import com.moonce.util.constant.Code;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = MoonceApplication.class)
public class UserTest {
    @Resource
    private UserRepository userRepository;
    @Resource
    private UserService userService;

    @Test
//    @Ignore
    public void testRegister(){
        User user = new User("louis","123456","Moonce","229010812@qq.com","moonce.com",new Date(),"register","maluyao","18896539969",0,CommonUtils.stringCastToDate("1995-10-29",Code.YYYY_MM_DD),(byte)1,null);
        userService.register(user);
    }
}
