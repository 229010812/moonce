package com.moonce.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_auth")
public class UserAuth {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private String userId;


    @Column(name = "identity_type")
    private String identityType;

    @Column(name = "open_id")
    private String openId;

    @Column(name = "credential")
    private String credential;




}
