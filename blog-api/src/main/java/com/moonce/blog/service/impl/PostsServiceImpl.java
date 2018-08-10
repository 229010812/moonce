package com.moonce.blog.service.impl;

import com.moonce.blog.service.PostsService;
import com.moonce.doman.Posts;
import com.moonce.doman.TermRelationships;
import com.moonce.doman.vo.Msg;
import com.moonce.repository.PostsRepository;
import com.moonce.repository.TermRelationshipsRepository;
import com.moonce.util.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Date;

@Service("postsService")
public class PostsServiceImpl implements PostsService {
    private PostsRepository postsRepository;

    private TermRelationshipsRepository termRelationshipsRepository;

    @Resource
    public void setTermRelationshipsRepository(TermRelationshipsRepository termRelationshipsRepository) {
        this.termRelationshipsRepository = termRelationshipsRepository;
    }
    @Resource
    public void setPostsRepository(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    @Override
    @Transactional
    public Msg addPosts(Integer postAuthorID, String postContent, String postTitle, String postExcerpt, Integer termTaxonomyID, String postStatus, String commentStatus, String postPassword, String postName, String postParent, String guid, String menuOrder, String postType, Long commentCount) {
        Posts posts = new Posts(postAuthorID,new Date(),postContent,postTitle,postExcerpt,postStatus,commentStatus,postPassword,postName,new Date(),postParent,guid,menuOrder,postType,commentCount);
        postsRepository.save(posts);
        TermRelationships termRelationships = new TermRelationships(posts.getId(),termTaxonomyID,null);
        termRelationshipsRepository.save(termRelationships);
        return ResultUtil.success();
    }

    @Override
    public Msg updatePosts(Integer id, Integer postAuthorID, String postContent, String postTitle, String postExcerpt, Integer termTaxonomyID, String postStatus, String commentStatus, String postPassword, String postName, String postParent, String guid, String menuOrder, String postType, Long commentCount,Date postDate) {
        Date postModified = new Date();
        Posts posts = new Posts(postAuthorID,postDate,postContent,postTitle,postExcerpt,postStatus,commentStatus,postPassword,postName,postModified,postParent,guid,menuOrder,postType,commentCount);
        posts.setId(id);
        postsRepository.save(posts);
        return ResultUtil.success(posts);
    }

    @Override
    public Msg deletePosts(Integer id) {
        Posts posts = new Posts();
        posts.setId(id);
        postsRepository.delete(posts);
        return ResultUtil.success();
    }
}
