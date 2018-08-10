package com.moonce.doman;

import javax.persistence.*;
import java.util.Date;

/**
 * 存储文章信息，包括文章标题、正文、摘要、作者、发布时间、访问密码、评论数、修改时间、文章地址等
 * {@link User}{@link Comments}{@link TermRelationships}
 */
@Entity(name = "b_posts")
public class Posts {
    /** 自增唯一 ID*/
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "roleSeq")
    @TableGenerator(name = "roleSeq", allocationSize = 1, table = "seq_table", pkColumnName = "seq_id", valueColumnName = "seq_count")
    private Integer id;
    /** 对应作者 ID*/
    @Column(name = "post_author")
    private Integer postAuthorID;
    /** 发布时间*/
    @Column(name = "post_date")
    private Date postDate;
    /** 正文*/
    @Column(name = "post_content")
    private String postContent;
    /** 标题*/
    @Column(name = "post_title")
    private String postTitle;
    /** 摘录*/
    @Column(name = "post_excerpt")
    private String postExcerpt;
    /** 文章状态（publish/auto-draft/inherit 等）*/
    @Column(name = "post_status")
    private String postStatus;
    /** 评论状态（open/closed）*/
    @Column(name = "comment_status")
    private String commentStatus;
    /** 文章密码*/
    @Column(name = "post_password")
    private String postPassword;
    /** 文章缩略名*/
    @Column(name = "post_name")
    private String postName;
    /** 修改时间*/
    @Column(name = "post_modified")
    private Date postModified;
    /** 父文章，主要用于 PAGE*/
    @Column(name = "post_parent")
    private String postParent;
    /** 唯一标识符（短链接）*/
    @Column(name = "guid")
    private String guid;
    /** 排序 ID*/
    @Column(name = "menu_order")
    private String menuOrder;
    /** 文章类型（post/page 等）*/
    @Column(name = "post_type")
    private String postType;
    /** 评论总数*/
    @Column(name = "comment_count")
    private long commentCount;

    public Posts() {
    }

    @Override
    public String toString() {
        return "Posts{" +
                "id=" + id +
                ", postAuthorID=" + postAuthorID +
                ", postDate=" + postDate +
                ", postContent='" + postContent + '\'' +
                ", postTitle='" + postTitle + '\'' +
                ", postExcerpt='" + postExcerpt + '\'' +
                ", postStatus='" + postStatus + '\'' +
                ", commentStatus='" + commentStatus + '\'' +
                ", postPassword='" + postPassword + '\'' +
                ", postName='" + postName + '\'' +
                ", postModified='" + postModified + '\'' +
                ", postParent='" + postParent + '\'' +
                ", guid='" + guid + '\'' +
                ", menuOrder='" + menuOrder + '\'' +
                ", postType='" + postType + '\'' +
                ", commentCount='" + commentCount + '\'' +
                '}';
    }

    public Posts(Integer postAuthorID, Date postDate, String postContent, String postTitle, String postExcerpt, String postStatus, String commentStatus, String postPassword, String postName, Date postModified, String postParent, String guid, String menuOrder, String postType, long commentCount) {
        this.postAuthorID = postAuthorID;
        this.postDate = postDate;
        this.postContent = postContent;
        this.postTitle = postTitle;
        this.postExcerpt = postExcerpt;
        this.postStatus = postStatus;
        this.commentStatus = commentStatus;
        this.postPassword = postPassword;
        this.postName = postName;
        this.postModified = postModified;
        this.postParent = postParent;
        this.guid = guid;
        this.menuOrder = menuOrder;
        this.postType = postType;
        this.commentCount = commentCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostAuthorID() {
        return postAuthorID;
    }

    public void setPostAuthorID(Integer postAuthorID) {
        this.postAuthorID = postAuthorID;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostExcerpt() {
        return postExcerpt;
    }

    public void setPostExcerpt(String postExcerpt) {
        this.postExcerpt = postExcerpt;
    }

    public String getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(String postStatus) {
        this.postStatus = postStatus;
    }

    public String getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(String commentStatus) {
        this.commentStatus = commentStatus;
    }

    public String getPostPassword() {
        return postPassword;
    }

    public void setPostPassword(String postPassword) {
        this.postPassword = postPassword;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Date getPostModified() {
        return postModified;
    }

    public void setPostModified(Date postModified) {
        this.postModified = postModified;
    }

    public String getPostParent() {
        return postParent;
    }

    public void setPostParent(String postParent) {
        this.postParent = postParent;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(String menuOrder) {
        this.menuOrder = menuOrder;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(long commentCount) {
        this.commentCount = commentCount;
    }
}
