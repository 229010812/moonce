package com.moonce.blog.service.impl;

import com.moonce.blog.service.UserService;
import com.moonce.doman.User;
import com.moonce.doman.UserVerification;
import com.moonce.repository.UserRepository;
import com.moonce.repository.UserVerificationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * {@link User} {@link Service}
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    private UserRepository userRepository;
    private UserVerificationRepository userVerificationRepository;

    @Resource
    public void setUserVerificationRepository(UserVerificationRepository userVerificationRepository) {
        this.userVerificationRepository = userVerificationRepository;
    }

    @Resource
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User signIn(String username, String password) {
        UserVerification userVerification = userVerificationRepository.findByAccountAndPassword(username,password);
        if(userVerification==null) return null;
        User user = userRepository.findById(userVerification.getUserId()).get();
        return user;
    }


    @Transactional
    public User register(User user) {
        //保存用户
        userRepository.save(user);
        //添加登录通行证
        addUserVerification(user.getId(),"username",user.getUserLogin(),user.getPassword());
        if(!"".equals(user.getEmail()))//添加邮箱登录通行证
            addUserVerification(user.getId(),"email",user.getEmail(),user.getPassword());
        if(!"".equals(user.getTel())) //添加手机登录通行证
            addUserVerification(user.getId(),"tel",user.getTel(),user.getPassword());
        return user;
    }

    @Override
    public User updateUser(User user) {
       User user1 =  userRepository.findById(user.getId()).get();
        //保存用户
        userRepository.save(user);
        return user;
    }

    /**
     * 添加用户通行证
     * @param id
     * @param type
     * @param account
     * @param password
     */
    private void addUserVerification(Integer id,String type,String account,String password){
        UserVerification userVerification = new UserVerification();
        userVerification.setUserId(id);
        userVerification.setType(type);
        userVerification.setAccount(account);
        userVerification.setPassword(password);
        userVerificationRepository.save(userVerification);
    }


}
