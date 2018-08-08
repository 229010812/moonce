package com.moonce.blog.controller;

import com.moonce.blog.service.UserService;
import com.moonce.doman.User;
import com.moonce.util.CommonUtils;
import com.moonce.util.constant.Code;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 用户信息 Controller
 * {@link User}{@link UserService}
 */
@RestController
public class UserController {

    private UserService userService;

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 用户登录验证
     * @param username 用户名
     * @param password 密码
     * @return 如果登录成功,返回<code>User</code>,如果登录失败返回<code>null</code>
     */
    @GetMapping(value = "/sign-in")
    public User signIn(@RequestParam("username") String username,
                       @RequestParam("password") String password){
        return userService.signIn(username,password);
    }


    /**
     * 用户注册
     * {@link User}{@link UserService}
     * @param userLogin
     * @param password
     * @param email
     * @param nicename
     * @param url
     * @param tel
     * @param birthday
     * @param sex
     * @return 如果注册成功,返回<code>User</code>,失败返回<code>null</code>
     */
    @PostMapping(value = "/register")
    public User register(@RequestParam(name = "userLogin") String userLogin,
                         @RequestParam(name = "password") String password,
                         @RequestParam(name = "email",required = false) String email,
                         @RequestParam(name = "nicename") String nicename,
                         @RequestParam(name = "url",required = false) String url,
                         @RequestParam(name = "tel",required = false) String tel,
                         @RequestParam(name = "birthday",required = false) String birthday,
                         @RequestParam(name = "sex",required = false,defaultValue = "0") byte sex
    ){
        User user = new User();
        user.setUserLogin(userLogin);
        user.setPassword(password);
        user.setEmail(email);
        user.setBirthday(CommonUtils.stringCastToDate(birthday, Code.YYYY_MM_DD));
        user.setSex(sex);
        user.setTel(tel);
        user.setUrl(url);
        user.setGrade(0);
        user.setRegistered(new Date());
        user.setStatus("register");
        user.setDisplayName(nicename);
        user.setNicename(nicename);

        return userService.register(user);
    }

    /**
     * 用户资料修改
     */
    @PutMapping(value = "/user/{id}")
    public String updateUser(@PathVariable("id") Integer id,
                             @RequestParam(name = "userLogin",required = false) String userLogin,
                             @RequestParam(name = "password",required = false) String password,
                             @RequestParam(name = "email",required = false) String email,
                             @RequestParam(name = "nicename",required = false) String nicename,
                             @RequestParam(name = "url",required = false) String url,
                             @RequestParam(name = "tel",required = false) String tel,
                             @RequestParam(name = "birthday",required = false) Date birthday,
                             @RequestParam(name = "sex",required = false,defaultValue = "0") byte sex){
        return null;
    }
}
