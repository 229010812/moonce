package com.moonce.bookkeeping.service;

import com.moonce.bookkeeping.entity.AssetsTransferRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AssetsTransferRecordService {
    void save(AssetsTransferRecord assetsTransferRecord);

    AssetsTransferRecord get(Integer id);

    List<AssetsTransferRecord> list(AssetsTransferRecord assetsTransferRecord);

    Page<AssetsTransferRecord> page(Pageable pageable);

    void delete(Integer id);
}
