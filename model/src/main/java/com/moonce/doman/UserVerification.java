package com.moonce.doman;

import javax.persistence.*;
import java.util.Date;

/**
 * 登录通行证
 * 用户验证-用于检测用户账户密码
 * #{@link User}
 */
@Entity(name = "m_user_verification")
public class UserVerification {
    /** 通行证ID*/
    @Id
    @GeneratedValue
    private Integer id;
    /** 用户ID*/
    @Column(name = "user_id")
    private Integer userId;
    /** 通行证类型 username 默认用户名 email 邮箱 tel手机号 qq QQ  we-chat 微信*/
    private String type;
    /** 账户*/
    private String account;
    /** 密码*/
    private String password;
    /** 过期日期*/
    private Date expirationDate;
    /** 创建时间*/
    private Date createDate;

    public UserVerification() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "UserVerification{" +
                "id=" + id +
                ", userId=" + userId +
                ", type='" + type + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", expirationDate=" + expirationDate +
                ", createDate=" + createDate +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
