package com.moonce.financing.service.impl;

import com.moonce.financing.entity.AssetsModifyRecord;
import com.moonce.financing.repository.AssetsModifyRecordRepository;
import com.moonce.financing.service.AssetsModifyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("assetsModifyRecordService")
public class AssetsModifyRecordServiceImpl implements AssetsModifyRecordService {
    @Autowired
    private AssetsModifyRecordRepository assetsModifyRecordRepository;
    @Override
    public void save(AssetsModifyRecord assetsModifyRecord) {
        assetsModifyRecordRepository.save(assetsModifyRecord);
    }

    @Override
    public AssetsModifyRecord get(Integer id) {
        return assetsModifyRecordRepository.getOne(id);
    }

    @Override
    public List<AssetsModifyRecord> list(AssetsModifyRecord assetsModifyRecord) {
        Example<AssetsModifyRecord> e =Example.of(assetsModifyRecord);
        Sort s = Sort.by(Sort.Direction.DESC,"id");
        return assetsModifyRecordRepository.findAll(e,s);
    }

    @Override
    public Page<AssetsModifyRecord> page(Pageable pageable) {
        Page<AssetsModifyRecord> page = assetsModifyRecordRepository.findAll(pageable);
        return page;
    }

    @Override
    public void delete(Integer id) {
        assetsModifyRecordRepository.deleteById(id);
    }
}
