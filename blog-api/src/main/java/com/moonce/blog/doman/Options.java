package com.moonce.blog.doman;

import javax.persistence.*;

/**
 * 存储 WordPress 系统默认及后台系统选项、插件及主题配置信息，包括网站标题、副标题、当前主题等等
 * {@link User}
 */
@Entity(name = "b_options")
public class Options {
    /** option_id：自增唯一 ID*/
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "roleSeq")
    @TableGenerator(name = "roleSeq", allocationSize = 1, table = "seq_table", pkColumnName = "seq_id", valueColumnName = "seq_count")
    @Column(name = "option_id")
    private Integer optionID;
    /** blog_id：博客 ID，用于多用户博客，默认 0*/
    @Column(name = "blog_id")
    private Integer blogID;
    /** option_name：键名*/
    @Column(name = "option_name")
    private String optionName;
    /** option_value：键值*/
    @Column(name = "option_value")
    private String optionValue;

    public Options() {
    }

    @Override
    public String toString() {
        return "Options{" +
                "optionID=" + optionID +
                ", blogID=" + blogID +
                ", optionName='" + optionName + '\'' +
                ", optionValue='" + optionValue + '\'' +
                '}';
    }

    public Integer getOptionID() {
        return optionID;
    }

    public void setOptionID(Integer optionID) {
        this.optionID = optionID;
    }

    public Integer getBlogID() {
        return blogID;
    }

    public void setBlogID(Integer blogID) {
        this.blogID = blogID;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }
}
