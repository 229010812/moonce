package com.moonce.bookkeeping.repository;

import com.moonce.bookkeeping.entity.RecordType;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface RecordTypeRepository extends JpaRepository<RecordType,Integer> {

}