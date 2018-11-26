package com.moonce.bookkeeping.service.impl;

import com.moonce.bookkeeping.entity.RecordType;
import com.moonce.bookkeeping.repository.RecordTypeRepository;
import com.moonce.bookkeeping.service.RecordTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("recordTypeService")
public class RecordTypeServiceImpl implements RecordTypeService {
    @Autowired
    private RecordTypeRepository recordTypeRepository;
    @Override
    public void save(RecordType recordType) {
        recordTypeRepository.save(recordType);
    }

    @Override
    public RecordType get(Integer id) {
        Optional<RecordType> o = recordTypeRepository.findById(id);
        return o.get();
    }

    @Override
    public List<RecordType> list(RecordType recordType) {
        Example<RecordType> e = Example.of(recordType);
        Sort s = new Sort(Sort.Direction.ASC,"ranking");
        return recordTypeRepository.findAll(e,s);
    }

    @Override
    public Page<RecordType> page(RecordType recordType,Pageable pageable) {
        Example<RecordType> example = Example.of(recordType);
        return recordTypeRepository.findAll(example,pageable);
    }

    @Override
    public void delete(Integer id) {
        recordTypeRepository.deleteById(id);
    }
}
