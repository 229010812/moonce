package com.moonce.bookkeeping.repository;

import com.moonce.bookkeeping.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface RecordRepository extends JpaRepository<Record,Integer> {

}
