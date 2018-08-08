package com.moonce.repository;

import com.moonce.doman.TermTaxonomy;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface TermTaxonomyRepository extends JpaRepository<TermTaxonomy,Integer> {
}
