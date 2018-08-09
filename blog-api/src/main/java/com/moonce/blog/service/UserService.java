package com.moonce.blog.service;


import com.moonce.doman.User;

public interface UserService {
    User signIn(String username, String password);

    User register(User user);

    User updateUser(User user);
}
