package com.moonce.financing.service.impl;

import com.moonce.financing.entity.AssetsTransferRecord;
import com.moonce.financing.repository.AssetsTransferRecordRepository;
import com.moonce.financing.service.AssetsTransferRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("assetsTransferRecordService")
public class AssetsTransferRecordServiceImpl implements AssetsTransferRecordService {
    @Autowired
    private AssetsTransferRecordRepository assetsTransferRecordRepository;

    @Override
    public void save(AssetsTransferRecord assetsTransferRecord) {
        assetsTransferRecordRepository.save(assetsTransferRecord);
    }

    @Override
    public AssetsTransferRecord get(Integer id) {
        Optional<AssetsTransferRecord> o = assetsTransferRecordRepository.findById(id);
        return o.get();
    }

    @Override
    public List<AssetsTransferRecord> list(AssetsTransferRecord assetsTransferRecord) {
        Example<AssetsTransferRecord> e =Example.of(assetsTransferRecord);
        Sort s = Sort.by(Sort.Direction.DESC,"id");
        return assetsTransferRecordRepository.findAll(e,s);
    }

    @Override
    public Page<AssetsTransferRecord> page(Pageable pageable) {
        return assetsTransferRecordRepository.findAll(pageable);
    }

    @Override
    public void delete(Integer id) {
        assetsTransferRecordRepository.deleteById(id);
    }
}
