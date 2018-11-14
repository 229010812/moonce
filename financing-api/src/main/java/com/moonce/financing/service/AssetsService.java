package com.moonce.financing.service;

import com.moonce.financing.entity.Assets;
import com.moonce.financing.entity.AssetsModifyRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AssetsService {
    void save(Assets assets);

    void update(Assets assets);

    Assets get(Integer id);

    List<Assets> list(Assets assets);

    Page<Assets> page(Pageable pageable);

    void delete(Integer id);
}
