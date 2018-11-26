package com.moonce.blog.repository;

import com.moonce.blog.doman.Terms;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface TermsRepository extends JpaRepository<Terms,Integer> {
}
