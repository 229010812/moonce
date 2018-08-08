package com.moonce.doman;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 用户信息
 * <code>@GeneratedValue</code>表示自增
 * l         unique属性表示该字段是否为唯一标识，默认为false。如果表中有一个字段需要唯一标识，则既可以使用该标记，也可以使用@Table标记中的@UniqueConstraint。
 * l         nullable属性表示该字段是否可以为null值，默认为true。
 * l         insertable属性表示在使用“INSERT”脚本插入数据时，是否需要插入该字段的值。
 * l         updatable属性表示在使用“UPDATE”脚本插入数据时，是否需要更新该字段的值。insertable和updatable属性一般多用于只读的属性，例如主键和外键等。这些字段的值通常是自动生成的。
 * l         columnDefinition属性表示创建表时，该字段创建的SQL语句，一般用于通过Entity生成表定义时使用。
 * l         table属性表示当映射多个表时，指定表的表中的字段。默认值为主表的表名。有关多个表的映射将在本章的5.6小节中详细讲述。
 * l         length属性表示字段的长度，当字段的类型为varchar时，该属性才有效，默认为255个字符。
 * l         precision属性和scale属性表示精度，当字段类型为double时，precision表示数值的总长度，scale表示小数点所占的位数。
 *
 */
@Entity(name = "m_user")
public class User {
    /** 用户id 自增唯一*/
    @Id
    @GeneratedValue
    private Integer id;

    /** 登录名*/
    @Column(name = "user_login", nullable = false, length = 30)
    private String userLogin;

    /** 密码*/
    @Column(name = "user_pass", nullable = false, length = 30)
    private String password;
    /** 昵称*/
    @Column(name = "user_nicename", nullable = false, length = 30)
    private String nicename;
    /** 邮箱*/
    @Column(name = "user_email", nullable = false, length = 30)
    private String email;
    /** 网站*/
    @Column(name = "user_url", length = 30)
    private String url;
    /** 注册时间*/
    @Column(name = "user_registered")
    private Date registered = new Date();
    /** 用户状态*/
    @Column(name = "user_status", nullable = false, length = 30)
    private String status;
    /** 显示名称*/
    @Column(name = "display_name", nullable = false, length = 30)
    private String displayName;
    /** 手机号*/
    @Column(name = "user_telephone", nullable = false, length = 30)
    private String tel;
    /** 等级*/
    @Column(name = "user_grade", nullable = false, length = 30)
    private Integer grade;
    /** 生日*/
    @Column(name = "user_birthday" )
    private Date birthday;
    /** 性别 1男 2女 0未知*/
    @Column(name = "user_sex",scale = 0)
    private byte sex = 0;
    /** 激活码*/
    @Column(name = "user_activation_key")
    private String activationKey;


    public User() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNicename() {
        return nicename;
    }

    public void setNicename(String nicename) {
        this.nicename = nicename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userLogin='" + userLogin + '\'' +
                ", password='" + password + '\'' +
                ", nicename='" + nicename + '\'' +
                ", email='" + email + '\'' +
                ", url='" + url + '\'' +
                ", registered=" + registered +
                ", status='" + status + '\'' +
                ", displayName='" + displayName + '\'' +
                ", tel='" + tel + '\'' +
                ", grade=" + grade +
                ", birthday=" + birthday +
                ", sex=" + sex +
                '}';
    }
}
