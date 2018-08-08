package com.moonce.repository;

import com.moonce.doman.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * 用户信息库
 * {@link User} {@link JpaRepository}
 */
@Transactional
public interface UserRepository extends JpaRepository<User,Integer> {

    @Modifying
    @Query(value = "UPDATE com.moonce.doman.User u SET u.email= :email WHERE u.id= :id ")
    int update(@Param("id") Integer id,@Param("email") String email);

}
