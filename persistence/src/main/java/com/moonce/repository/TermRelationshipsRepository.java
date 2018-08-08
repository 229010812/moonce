package com.moonce.repository;

import com.moonce.doman.TermRelationships;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface TermRelationshipsRepository extends JpaRepository<TermRelationships,Integer> {
}
