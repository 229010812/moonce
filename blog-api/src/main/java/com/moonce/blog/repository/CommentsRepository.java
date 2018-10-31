package com.moonce.blog.repository;

import com.moonce.blog.doman.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CommentsRepository extends JpaRepository<Comments,Integer> {
}
