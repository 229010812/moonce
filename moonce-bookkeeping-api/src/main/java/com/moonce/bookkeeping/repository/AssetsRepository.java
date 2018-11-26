package com.moonce.bookkeeping.repository;

import com.moonce.bookkeeping.entity.Assets;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface AssetsRepository extends JpaRepository<Assets,Integer> {

}
