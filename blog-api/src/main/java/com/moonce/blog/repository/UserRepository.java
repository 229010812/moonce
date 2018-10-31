package com.moonce.blog.repository;

import com.moonce.blog.doman.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    //分页查询 查询计算元素总个数总页数，数据多的情况下，代价是昂贵的
    Page<User> findByUserLoginLike(String userLogin, Pageable pageable);
    //分页查询，返回的是一个片段，它只知道下一片段或者上一片段是否可用。
//    Slice<User> findByUserLoginLike(String userLogin, Pageable pageable);

}
