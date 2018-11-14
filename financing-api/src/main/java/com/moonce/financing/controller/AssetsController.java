package com.moonce.financing.controller;

import com.moonce.common.util.ResultUtil;
import com.moonce.common.vo.Msg;
import com.moonce.financing.entity.Assets;
import com.moonce.financing.service.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/asset")
public class AssetsController {
    @Autowired
    private AssetsService assetsService;


    @Autowired
    public void setAssetsService(AssetsService assetsService) {
        this.assetsService = assetsService;
    }
    @PostMapping("/save")
    public Msg save(){
        Assets asset = new Assets();
        asset.setMoney(new BigDecimal("20.222"));
        assetsService.save(asset);
        return ResultUtil.success();
    }
}
