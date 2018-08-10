package com.moonce.blog.controller;

import com.moonce.blog.service.PostsService;
import com.moonce.doman.vo.Msg;
import com.moonce.util.CommonUtils;
import com.moonce.util.LogUtils;
import com.moonce.util.ResultUtil;
import com.moonce.util.constant.Code;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 文章模块 Controller
 *
 */
@RestController
@RequestMapping("/posts")
public class PostsController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private PostsService postsService;

    @Resource
    public void setPostsService(PostsService postsService) {
        this.postsService = postsService;
    }

    // TODO: 2018/8/8 文章列表分页查询
    /**
     *  新增文章
     * @param postAuthorID 作者ID
     * @param postContent 文章内容
     * @param postTitle 标题
     * @param postStatus 状态
     * @param commentStatus 评论状态
     * @param postPassword 文章密码
     * @param postName 文章缩略名
     * @param postParent 父文章
     * @param guid 唯一标识符（短链接）
     * @param menuOrder 排序
     * @param postType  文章类型
     * @param commentCount  评论总数
     * @return
     */
    @PostMapping("/post")
    public Msg addPosts(@RequestParam(name = "postAuthorID") Integer postAuthorID,
                        @RequestParam(name = "postContent") String postContent,
                        @RequestParam(name = "postTitle") String postTitle,
                        @RequestParam(name = "postExcerpt",required = false) String postExcerpt,
                        @RequestParam(name = "termTaxonomyID") Integer termTaxonomyID,
                        @RequestParam(name = "postStatus",required = false,defaultValue = "auto-draft") String postStatus,
                        @RequestParam(name = "commentStatus",required = false,defaultValue = "open") String commentStatus,
                        @RequestParam(name = "postPassword",required = false) String postPassword,
                        @RequestParam(name = "postName",required = false) String postName,
                        @RequestParam(name = "postParent",required = false) String postParent,
                        @RequestParam(name = "guid",required = false) String guid,
                        @RequestParam(name = "menuOrder",required = false) String menuOrder,
                        @RequestParam(name = "postType",required = false,defaultValue = "text") String postType,
                        @RequestParam(name = "commentCount",required = false,defaultValue = "0") Long commentCount
                        ){
        try {
            return postsService.addPosts(postAuthorID,postContent,postTitle,postExcerpt,termTaxonomyID,postStatus,commentStatus,postPassword,postName,postParent,guid,menuOrder,postType,commentCount);
        }catch (Exception e){
            logger.error(LogUtils.getException(e));
        }
        return ResultUtil.error(Code.FAILED,"创建失败");
    }
    // TODO: 2018/8/8 编辑文章
    /**
     *  编辑文章
     * @param postAuthorID 作者ID
     * @param postContent 文章内容
     * @param postTitle 标题
     * @param postStatus 状态
     * @param commentStatus 评论状态
     * @param postPassword 文章密码
     * @param postName 文章缩略名
     * @param postParent 父文章
     * @param guid 唯一标识符（短链接）
     * @param menuOrder 排序
     * @param postType  文章类型
     * @param commentCount  评论总数
     * @return
     */
    @PutMapping("/post/{id}")
    public Msg updatePosts(@PathVariable(name = "id") Integer id,
                        @RequestParam(name = "postAuthorID") Integer postAuthorID,
                        @RequestParam(name = "postContent") String postContent,
                        @RequestParam(name = "postTitle") String postTitle,
                        @RequestParam(name = "postExcerpt",required = false) String postExcerpt,
                        @RequestParam(name = "termTaxonomyID") Integer termTaxonomyID,
                        @RequestParam(name = "postStatus",required = false,defaultValue = "auto-draft") String postStatus,
                        @RequestParam(name = "commentStatus",required = false,defaultValue = "open") String commentStatus,
                        @RequestParam(name = "postPassword",required = false) String postPassword,
                        @RequestParam(name = "postName",required = false) String postName,
                        @RequestParam(name = "postParent",required = false) String postParent,
                        @RequestParam(name = "guid",required = false) String guid,
                        @RequestParam(name = "guid",required = false) String postDate,
                        @RequestParam(name = "menuOrder",required = false) String menuOrder,
                        @RequestParam(name = "postType",required = false,defaultValue = "text") String postType,
                        @RequestParam(name = "commentCount",required = false,defaultValue = "0") Long commentCount
    ){
        try {
            return postsService.updatePosts(id,postAuthorID,postContent,postTitle,postExcerpt,termTaxonomyID,postStatus,commentStatus,postPassword,postName,postParent,guid,menuOrder,postType,commentCount,CommonUtils.stringCastToDate(postDate,Code.YYYY_MM_DD_HH_MM_SS));
        }catch (Exception e){
            logger.error(LogUtils.getException(e));
        }
        return ResultUtil.error(Code.FAILED,"编辑失败");
    }

    /**
     * 删除文章
     * @param id
     * @return
     */
    @DeleteMapping("/post/{id}")
    public Msg deletePost(@PathVariable(name = "id") Integer id){
        try {
            return postsService.deletePosts(id);
        }catch (Exception e){
            logger.error(LogUtils.getException(e));
        }
        return ResultUtil.error(Code.FAILED,"删除失败");
    }
}
