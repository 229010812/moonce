package com.moonce.blog.doman;

import javax.persistence.*;

/**
 * 存储评论信息，如评论内容、评论所属文章、评论人昵称、邮箱、URL 等；
 * {@link Posts}{@link User}
 */
@Entity(name = "b_comments")
public class Comments {
    public Comments() {
    }
    /** 自增唯一 ID*/
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "roleSeq")
    @TableGenerator(name = "roleSeq", allocationSize = 1, table = "seq_table", pkColumnName = "seq_id", valueColumnName = "seq_count")
    @Column(name = "comment_id")
    private Integer id;
    /** 对应文章 ID*/
    @Column(name = "comment_post_id")
    private Integer postId;
    /** 评论者*/
    @Column(name = "comment_author")
    private Integer author;
    /** 评论者邮箱*/
    @Column(name = "comment_author_email")
    private Integer authorEmail;
    /** 评论者网址*/
    @Column(name = "comment_author_url")
    private Integer authorUrl;
    /** 评论者 IP*/
    @Column(name = "comment_author_ip")
    private Integer authorIP;
    /** 评论时间*/
    @Column(name = "comment_date")
    private Integer commentDate;
    /** 评论正文*/
    @Column(name = "comment_content")
    private Integer commentContent;
    /** 评论是否被批准*/
    @Column(name = "comment_approved")
    private Integer commentApproved;
    /** 评论者的 USER AGENT*/
    @Column(name = "comment_agent")
    private Integer commentAgent;
    /** 评论类型(pingback/普通)*/
    @Column(name = "comment_type")
    private Integer commentType;
    /** 父评论 ID*/
    @Column(name = "comment_parent")
    private Integer commentParent;
    /** 评论者用户 ID（未登录用户的评论则为空)*/
    @Column(name = "user_id")
    private Integer userId;

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", postId=" + postId +
                ", author=" + author +
                ", authorEmail=" + authorEmail +
                ", authorUrl=" + authorUrl +
                ", authorIP=" + authorIP +
                ", commentDate=" + commentDate +
                ", commentContent=" + commentContent +
                ", commentApproved=" + commentApproved +
                ", commentAgent=" + commentAgent +
                ", commentType=" + commentType +
                ", commentParent=" + commentParent +
                ", userId=" + userId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public Integer getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(Integer authorEmail) {
        this.authorEmail = authorEmail;
    }

    public Integer getAuthorUrl() {
        return authorUrl;
    }

    public void setAuthorUrl(Integer authorUrl) {
        this.authorUrl = authorUrl;
    }

    public Integer getAuthorIP() {
        return authorIP;
    }

    public void setAuthorIP(Integer authorIP) {
        this.authorIP = authorIP;
    }

    public Integer getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Integer commentDate) {
        this.commentDate = commentDate;
    }

    public Integer getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(Integer commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getCommentApproved() {
        return commentApproved;
    }

    public void setCommentApproved(Integer commentApproved) {
        this.commentApproved = commentApproved;
    }

    public Integer getCommentAgent() {
        return commentAgent;
    }

    public void setCommentAgent(Integer commentAgent) {
        this.commentAgent = commentAgent;
    }

    public Integer getCommentType() {
        return commentType;
    }

    public void setCommentType(Integer commentType) {
        this.commentType = commentType;
    }

    public Integer getCommentParent() {
        return commentParent;
    }

    public void setCommentParent(Integer commentParent) {
        this.commentParent = commentParent;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
