package com.moonce.blog.controller;

import com.moonce.blog.service.CommentsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 评论模块 Controller
 * {@link com.moonce.blog.doman.Comments}{@link CommentsService}
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {

    private CommentsService commentsService;

    @Resource
    public void setCommentsService(CommentsService commentsService) {
        this.commentsService = commentsService;
    }


    // TODO: 2018/8/8  对文章进行新增评论
    @PostMapping("/comments/{postsID}")
    public String addComments(@PathVariable("postsID") Integer postsID){
        return null;
    }

    // TODO: 2018/8/8 删除评论
    @DeleteMapping("/delete/{id}")
    public String deleteComments(@PathVariable("id") Integer id){
        return null;
    }

    // TODO: 2018/8/8 编辑评论内容
    @PutMapping("/comments/{id}")
    public String updateComments(@PathVariable("id") Integer id){
        return null;
    }

    // TODO: 2018/8/8 查询文章对应评论
    @GetMapping("/comments/{postsID}")
    public String getPostsComments(@PathVariable("postsID") Integer postsID){
        return null;
    }
}
