package com.moonce.repository;

import com.moonce.doman.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface PostsRepository extends JpaRepository<Posts,Integer> {
}
