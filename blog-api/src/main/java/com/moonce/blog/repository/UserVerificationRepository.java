package com.moonce.blog.repository;

import com.moonce.blog.doman.UserVerification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserVerificationRepository extends JpaRepository<UserVerification,Integer> {
    UserVerification findByAccountAndPassword(String username,String password);
}
