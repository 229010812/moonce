package com.moonce.blog.service;


import com.moonce.doman.vo.Msg;
import com.moonce.doman.User;

public interface UserService {
    User signIn(String username, String password);

    User register(User user);

    Msg updateUser(Integer id, String userLogin, String password, String email, String nicename, String displayName, String url, String tel, String birthday, String status, byte sex);

    Msg userListPage(Integer pageNum, Integer pageSize);
}
