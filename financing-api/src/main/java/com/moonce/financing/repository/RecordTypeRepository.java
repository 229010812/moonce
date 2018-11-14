package com.moonce.financing.repository;

import com.moonce.financing.entity.RecordType;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface RecordTypeRepository extends JpaRepository<RecordType,Integer> {

}