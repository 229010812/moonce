package com.moonce.repository;

import com.moonce.doman.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CommentsRepository extends JpaRepository<Comments,Integer> {
}
