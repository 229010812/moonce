package com.moonce.financing.repository;

import com.moonce.financing.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface LabelRepository extends JpaRepository<Label,Integer> {

}
