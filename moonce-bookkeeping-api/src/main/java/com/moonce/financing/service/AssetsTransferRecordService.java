package com.moonce.financing.service;

import com.moonce.financing.entity.Assets;
import com.moonce.financing.entity.AssetsModifyRecord;
import com.moonce.financing.entity.AssetsTransferRecord;
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
