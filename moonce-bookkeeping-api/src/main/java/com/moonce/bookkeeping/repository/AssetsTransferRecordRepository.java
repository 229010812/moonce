package com.moonce.bookkeeping.repository;

import com.moonce.bookkeeping.entity.AssetsTransferRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface AssetsTransferRecordRepository extends JpaRepository<AssetsTransferRecord,Integer> {

}
