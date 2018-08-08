package com.moonce.repository;

import com.moonce.doman.UserVerification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserVerificationRepository extends JpaRepository<UserVerification,Integer> {
    UserVerification findByAccountAndPassword(String username,String password);
}
