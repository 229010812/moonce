package com.moonce.blog.service.impl;

import com.moonce.blog.service.UserService;
import com.moonce.doman.vo.Msg;
import com.moonce.doman.User;
import com.moonce.doman.UserVerification;
import com.moonce.doman.vo.PageVo;
import com.moonce.repository.UserRepository;
import com.moonce.repository.UserVerificationRepository;
import com.moonce.util.CommonUtils;
import com.moonce.util.EncryptionPWDUtil;
import com.moonce.util.ResultUtil;
import com.moonce.util.constant.Code;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 *
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

    @Override
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
    @Transactional
    public Msg updateUser(Integer id, String userLogin, String password, String email, String nicename, String displayName, String url, String tel, String birthday, String status, byte sex) {
        User user =userRepository.findById(id).get();
        if(user==null) return ResultUtil.error(Code.FAILED_OPERATION,"用户不存在!");
        if(!"".equals(userLogin)) user.setUserLogin(userLogin);
        if(!"".equals(password)) user.setPassword(EncryptionPWDUtil.encode(password));
        if(!"".equals(email)) user.setEmail(email);
        if(!"".equals(birthday)) user.setBirthday(CommonUtils.stringCastToDate(birthday, Code.YYYY_MM_DD));
        if(sex!=0) user.setSex(sex);
        if(!"".equals(tel)) user.setTel(tel);
        if(!"".equals(url)) user.setUrl(url);
        if(!"".equals(status)) user.setStatus("register");
        if(!"".equals(displayName)) user.setDisplayName(displayName);
        if(!"".equals(nicename)) user.setNicename(nicename);
        //修改用户
        userRepository.save(user);
        return  ResultUtil.success(user);
    }

    @Override
    public Msg userListPage(Integer pageNum, Integer pageSize) {
        Pageable pageable = new PageRequest(pageNum-1,pageSize);
        Page<User> userList = userRepository.findByUserLoginLike("%", pageable);
        PageVo pageVo = new PageVo(userList);
        System.out.println(ResultUtil.success(pageVo).toString());
        return ResultUtil.success(pageVo);
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
