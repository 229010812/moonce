package com.moonce.repository;

import com.moonce.doman.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;

@Transactional
public interface PostsRepository extends JpaRepository<Posts,Integer> {

//    int saveSelective(@Param("id") Integer id, Integer postAuthorID, Date postDate, String postContent, String postTitle, String postExcerpt, String postStatus, String commentStatus, String postPassword, String postName, Date postModified, String postParent, String guid, String menuOrder, String postType, Long commentCount);
}
