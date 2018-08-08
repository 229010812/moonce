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

        userRepository.save(user);
        //添加登录通行证
        UserVerification userVerification = new UserVerification();
        userVerification.setUserId(user.getId());
        userVerification.setAccount(user.getUserLogin());
        userVerification.setPassword(user.getPassword());
        userVerificationRepository.save(userVerification);
        if(!"".equals(user.getEmail())){
            userVerification=new UserVerification();
            userVerification.setUserId(user.getId());
            userVerification.setType("email");//邮箱类型
            userVerification.setAccount(user.getEmail());
            userVerification.setPassword(user.getPassword());
            userVerificationRepository.save(userVerification);
        }
        if(!"".equals(user.getTel())){
            userVerification=new UserVerification();
            userVerification.setUserId(user.getId());
            userVerification.setType("tel");//手机号类型
            userVerification.setAccount(user.getTel());
            userVerification.setPassword(user.getPassword());
            userVerificationRepository.save(userVerification);
        }

        return user;
    }


}
