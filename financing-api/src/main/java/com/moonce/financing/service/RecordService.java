package com.moonce.financing.service;

import com.moonce.financing.entity.Label;
import com.moonce.financing.entity.Record;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RecordService {
    void save(Record record);

    Record get(Integer id);

    List<Record> list(Record record);

    Page<Record> page(Pageable pageable);

    void delete(Integer id);
}
