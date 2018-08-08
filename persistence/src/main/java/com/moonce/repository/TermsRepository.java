package com.moonce.repository;

import com.moonce.doman.Terms;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface TermsRepository extends JpaRepository<Terms,Integer> {
}
