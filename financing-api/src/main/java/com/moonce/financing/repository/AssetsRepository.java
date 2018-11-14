package com.moonce.financing.repository;

import com.moonce.financing.entity.Assets;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface AssetsRepository extends JpaRepository<Assets,Integer> {

}
