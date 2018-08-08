package com.moonce.repository;

import com.moonce.doman.Options;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface OptionsRepository extends JpaRepository<Options,Integer> {
}
