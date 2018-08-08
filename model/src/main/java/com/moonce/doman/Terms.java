package com.moonce.doman;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 存储菜单分类、标签分类名称及 URL 信息
 *
 */
@Entity(name = "b_terms")
public class Terms {
    /** term_id：分类 ID 自增*/
    @Id
    @GeneratedValue
    @Column(name = "term_id")
    private Integer termID;
    /** name：分类名*/
    @Column(name = "name")
    private String name;
    /** slug：缩略名*/
    @Column(name = "slug")
    private String slug;
    /** term_group：分组*/
    @Column(name = "term_group")
    private String termGroup;

    public Terms() {
    }

    @Override
    public String toString() {
        return "Terms{" +
                "termID=" + termID +
                ", name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", termGroup='" + termGroup + '\'' +
                '}';
    }

    public Integer getTermID() {
        return termID;
    }

    public void setTermID(Integer termID) {
        this.termID = termID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTermGroup() {
        return termGroup;
    }

    public void setTermGroup(String termGroup) {
        this.termGroup = termGroup;
    }
}
