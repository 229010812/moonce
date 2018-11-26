package com.moonce.blog.service;

import com.moonce.common.vo.Msg;

import java.util.Date;

public interface PostsService {
    Msg addPosts(Integer postAuthorID, String postContent, String postTitle, String postExcerpt, Integer termTaxonomyID, String postStatus, String commentStatus, String postPassword, String postName, String postParent, String guid, String menuOrder, String postType, Long commentCount);

    Msg updatePosts(Integer id, Integer postAuthorID, String postContent, String postTitle, String postExcerpt, Integer termTaxonomyID, String postStatus, String commentStatus, String postPassword, String postName, String postParent, String guid, String menuOrder, String postType, Long commentCount, Date updatePosts);

    Msg deletePosts(Integer id);
}
