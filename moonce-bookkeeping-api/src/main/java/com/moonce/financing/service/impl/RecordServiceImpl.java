package com.moonce.financing.service.impl;

import com.moonce.common.util.UpdateTool;
import com.moonce.financing.entity.Record;
import com.moonce.financing.repository.RecordRepository;
import com.moonce.financing.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("recordService")
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordRepository recordRepository;
    @Override
    public void save(Record record) {
        recordRepository.save(record);
    }

    @Override
    public Record get(Integer id) {
        Optional<Record> o = recordRepository.findById(id);
        return o.get();
    }

    @Override
    public List<Record> list(Record record) {
        Example<Record> e = Example.of(record);
        Sort s = new Sort(Sort.Direction.DESC,"id");
        return recordRepository.findAll(e,s);
    }

    @Override
    public Page<Record> page(Pageable pageable) {
        return recordRepository.findAll(pageable);
    }

    @Override
    public void delete(Integer id) {
        recordRepository.deleteById(id);
    }

    @Override
    public void add(Record record) {
        recordRepository.save(record);
    }

    @Override
    public void update(Record record) {
        if(record.getId() != null){
            Optional<Record> source = recordRepository.findById(record.getId());
            UpdateTool.copyNullProperties(source.get(),record);
            recordRepository.save(record);
        }
    }
}
