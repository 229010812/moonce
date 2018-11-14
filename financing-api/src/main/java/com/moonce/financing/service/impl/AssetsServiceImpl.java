package com.moonce.financing.service.impl;

import com.moonce.financing.entity.Assets;
import com.moonce.financing.repository.AssetsRepository;
import com.moonce.financing.service.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("assetsService")
public class AssetsServiceImpl implements AssetsService {
    @Autowired
    private AssetsRepository assetsRepository;

    @Override
    public void save(Assets assets) {
        assetsRepository.save(assets);
    }
}
