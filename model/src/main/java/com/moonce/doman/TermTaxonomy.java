package com.moonce.doman;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 存储分类和标签的描述信息、父子关系、所属包含的文章数等；
 * term_taxonomy_id：自定义分类 ID
 * term_id：分类 ID
 * taxonomy：分类(category/post_tag)
 * description：分类描述
 * parent：所属父分类 ID
 * count：文章数统计
 * {@link Terms}
 */
@Entity(name = "b_term_taxonomy")
public class TermTaxonomy {
    /** term_taxonomy_id：自定义分类 ID 自增*/
    @Id
    @GeneratedValue
    @Column(name = "term_taxonomy_id")
    private Integer termTaxonomyID;
    /** term_id：分类 ID */
    @Column(name = "term_id")
    private Integer termID;
    /** taxonomy：分类(category/post_tag) */
    @Column(name = "taxonomy")
    private String taxonomy;
    /** description：分类描述 */
    @Column(name = "description")
    private String description;
    /** parent：所属父分类 ID */
    @Column(name = "parent")
    private String parent;
    /** count：文章数统计 */
    @Column(name = "count")
    private long count = 0;

    public TermTaxonomy() {
    }

    @Override
    public String toString() {
        return "TermTaxonomy{" +
                "termTaxonomyID=" + termTaxonomyID +
                ", termID=" + termID +
                ", taxonomy='" + taxonomy + '\'' +
                ", description='" + description + '\'' +
                ", parent='" + parent + '\'' +
                ", count=" + count +
                '}';
    }

    public Integer getTermTaxonomyID() {
        return termTaxonomyID;
    }

    public void setTermTaxonomyID(Integer termTaxonomyID) {
        this.termTaxonomyID = termTaxonomyID;
    }

    public Integer getTermID() {
        return termID;
    }

    public void setTermID(Integer termID) {
        this.termID = termID;
    }

    public String getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(String taxonomy) {
        this.taxonomy = taxonomy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
