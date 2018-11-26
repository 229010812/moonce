package com.moonce.bookkeeping.repository;

import com.moonce.bookkeeping.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface LabelRepository extends JpaRepository<Label,Integer> {

}
