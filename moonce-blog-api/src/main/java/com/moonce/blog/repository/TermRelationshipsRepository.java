package com.moonce.blog.repository;

import com.moonce.blog.doman.TermRelationships;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface TermRelationshipsRepository extends JpaRepository<TermRelationships,Integer> {
}
