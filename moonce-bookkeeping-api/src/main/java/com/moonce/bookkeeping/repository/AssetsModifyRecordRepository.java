package com.moonce.bookkeeping.repository;

import com.moonce.bookkeeping.entity.AssetsModifyRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface AssetsModifyRecordRepository extends JpaRepository<AssetsModifyRecord,Integer> {

}
