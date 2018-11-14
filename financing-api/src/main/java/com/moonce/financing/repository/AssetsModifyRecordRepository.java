package com.moonce.financing.repository;

import com.moonce.financing.entity.AssetsModifyRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface AssetsModifyRecordRepository extends JpaRepository<AssetsModifyRecord,Integer> {

}
