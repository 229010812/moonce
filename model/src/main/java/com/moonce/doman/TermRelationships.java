package com.moonce.doman;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 存储文章和分类、标签的相互对应关系
 * {@link Comments}{@link Terms}{@link TermTaxonomy}
 */
@Entity(name = "b_term_relationships")
public class TermRelationships {
    /** object_id：对应文章 ID/链接 ID*/

    @Column(name = "object_id")
    private Integer objectID;
    /** term_taxonomy_id：对应自定义分类 ID*/
    @Column(name = "term_taxonomy_id")
    private Integer termTaxonomyID;
    /** term_order：排序*/
    @Column(name = "term_order")
    private String termOrder;

    public TermRelationships() {
    }

    @Override
    public String toString() {
        return "TermRelationships{" +
                "objectID=" + objectID +
                ", termTaxonomyID=" + termTaxonomyID +
                ", termOrder='" + termOrder + '\'' +
                '}';
    }

    public Integer getObjectID() {
        return objectID;
    }

    public void setObjectID(Integer objectID) {
        this.objectID = objectID;
    }

    public Integer getTermTaxonomyID() {
        return termTaxonomyID;
    }

    public void setTermTaxonomyID(Integer termTaxonomyID) {
        this.termTaxonomyID = termTaxonomyID;
    }

    public String getTermOrder() {
        return termOrder;
    }

    public void setTermOrder(String termOrder) {
        this.termOrder = termOrder;
    }
}
