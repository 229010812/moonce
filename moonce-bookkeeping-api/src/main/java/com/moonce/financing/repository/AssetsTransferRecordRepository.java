package com.moonce.financing.repository;

import com.moonce.financing.entity.AssetsTransferRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface AssetsTransferRecordRepository extends JpaRepository<AssetsTransferRecord,Integer> {

}
