package com.moonce.bookkeeping.service.impl;

import com.moonce.common.util.UpdateTool;
import com.moonce.bookkeeping.entity.Assets;
import com.moonce.bookkeeping.repository.AssetsRepository;
import com.moonce.bookkeeping.service.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("assetsService")
public class AssetsServiceImpl implements AssetsService {
    @Autowired
    private AssetsRepository assetsRepository;

    @Override
    public void save(Assets assets) {
        assetsRepository.save(assets);
    }

    @Override
    public void update(Assets assets) {
        if(assets.getId() != null){
            Optional<Assets> source = assetsRepository.findById(assets.getId());
            UpdateTool.copyNullProperties(source.get(),assets);
            assetsRepository.save(assets);
        }
    }

    @Override
    public Assets get(Integer id) {
        Optional<Assets> o = assetsRepository.findById(id);
        return o.get();
    }

    @Override
    public List<Assets> list(Assets assets) {
        Example<Assets> e =Example.of(assets);
        Sort s = Sort.by(Sort.Direction.DESC,"id");
        return assetsRepository.findAll(e,s);
    }

    @Override
    public Page<Assets> page(Pageable pageable) {
        return assetsRepository.findAll(pageable);
    }

    @Override
    public void delete(Integer id) {
        assetsRepository.deleteById(id);
    }
}
