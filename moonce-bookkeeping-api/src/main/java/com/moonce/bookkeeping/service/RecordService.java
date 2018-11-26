package com.moonce.bookkeeping.service;

import com.moonce.bookkeeping.entity.Record;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RecordService {
    void save(Record record);

    Record get(Integer id);

    List<Record> list(Record record);

    Page<Record> page(Pageable pageable);

    void delete(Integer id);

    void add(Record record);

    void update(Record record);
}
