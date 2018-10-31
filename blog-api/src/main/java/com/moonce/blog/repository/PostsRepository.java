package com.moonce.blog.repository;

import com.moonce.blog.doman.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface PostsRepository extends JpaRepository<Posts,Integer> {

//    int saveSelective(@Param("id") Integer id, Integer postAuthorID, Date postDate, String postContent, String postTitle, String postExcerpt, String postStatus, String commentStatus, String postPassword, String postName, Date postModified, String postParent, String guid, String menuOrder, String postType, Long commentCount);
}
