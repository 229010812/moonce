package com.moonce.blog.repository;

import com.moonce.blog.doman.Options;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface OptionsRepository extends JpaRepository<Options,Integer> {
}
