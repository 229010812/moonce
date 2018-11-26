package com.moonce.bookkeeping.service;

import com.moonce.bookkeeping.entity.RecordType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RecordTypeService {
    void save(RecordType recordType);

    RecordType get(Integer id);

    List<RecordType> list(RecordType recordType);

    Page<RecordType> page(RecordType recordType,Pageable pageable);

    void delete(Integer id);
}
