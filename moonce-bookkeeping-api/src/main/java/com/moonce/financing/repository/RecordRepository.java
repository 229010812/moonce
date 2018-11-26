package com.moonce.financing.repository;

import com.moonce.financing.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface RecordRepository extends JpaRepository<Record,Integer> {

}
