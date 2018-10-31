package com.moonce.blog.doman;

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
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "roleSeq")
    @TableGenerator(name = "roleSeq", allocationSize = 1, table = "seq_table", pkColumnName = "seq_id", valueColumnName = "seq_count")
    private Integer id;
    /** 用户ID*/
    @Column(name = "user_id")
    private Integer userId;
    /** 通行证类型 username 默认用户名 email 邮箱 tel手机号 qq QQ  we-chat 微信*/
    private String type;
    /** 账户*/
    @Column(name = "account",unique = true,nullable = false)
    private String account;
    /** 密码*/
    @Column(name = "password",nullable = false,length = 32)
    private String password;
    /** 过期日期*/
    @Column(name = "expiration_date")
    private Date expirationDate;
    /** 创建时间*/
    @Column(name = "create_date")
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
