package com.moonce.user.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "user")
public class Account implements Serializable {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "account")
    private String account;

    @Column(name = "pwd")
    private String pwd;
}
