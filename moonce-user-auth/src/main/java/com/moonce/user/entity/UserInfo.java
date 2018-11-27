package com.moonce.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "user_info")
public class UserInfo {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "head_thumb")
    private String headThumb ;

    @Column(name = "gender")
    private String gender ;

    @Column(name = "birth_date")
    private String birthDate ;

    @Column(name = "login_ip ")
    private String loginIp ;

    @Column(name = "login_time ")
    private Date loginTime ;

    @Column(name = "regist_ip ")
    private String registIp ;

    @Column(name = "regist_time ")
    private Date registTime ;

    @Column(name = "last_time ")
    private Date lastTime ;

}
