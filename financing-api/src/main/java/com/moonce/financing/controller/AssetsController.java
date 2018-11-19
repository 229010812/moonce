package com.moonce.financing.controller;

import com.moonce.common.util.ResultUtil;
import com.moonce.common.util.UpdateTool;
import com.moonce.common.vo.Msg;
import com.moonce.financing.entity.Assets;
import com.moonce.financing.entity.AssetsModifyRecord;
import com.moonce.financing.entity.AssetsTransferRecord;
import com.moonce.financing.service.AssetsModifyRecordService;
import com.moonce.financing.service.AssetsService;
import com.moonce.financing.service.AssetsTransferRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 资产账户Controller
 */
@RestController
@RequestMapping("/asset")
public class AssetsController {
    @Autowired
    private AssetsService assetsService;
    @Autowired
    private AssetsTransferRecordService assetsTransferRecordService;
    @Autowired
    private AssetsModifyRecordService assetsModifyRecordService;


    @Autowired
    public void setAssetsService(AssetsService assetsService) {
        this.assetsService = assetsService;
    }

    /**
     * 新增资产账户
     * @param asset
     * @return
     */
    @PostMapping("/add")
    public Msg save(Assets asset){
        asset.setInitMoney(asset.getMoney());
        asset.setCreateTime(new Date());
        assetsService.save(asset);
        return ResultUtil.success(asset);
    }
    /**
     * 修改资产账户
     * @param asset
     * @return
     */
    @PutMapping("/update")
    public Msg update(Assets asset){
        Integer id = asset.getId();
        Assets source = assetsService.get(id);
        asset.setMoney(null);
        UpdateTool.copyNullProperties(source,asset);
        assetsService.update(asset);
        return ResultUtil.success();
    }

    /**
     * 修改资产账户资金
     * @param id
     * @param money
     * @return
     */
    @PostMapping("/update-money")
    public Msg updateMoney(Integer id,BigDecimal money){
        Assets assets = new Assets(id,money);
        if(assets.getId() != null){
            Assets source = assetsService.get(id);
            AssetsModifyRecord assetsModifyRecord = new AssetsModifyRecord(id,source.getMoney(),assets.getMoney(),0,new Date());
            UpdateTool.copyNullProperties(source,assets);
            assetsService.save(assets);
            assetsModifyRecordService.save(assetsModifyRecord);
        }
        return ResultUtil.success(assets);
    }

    /**
     * 资产账户转帐
     * @param assetsIdFrom 出账账户
     * @param assetsIdTo 入账账户
     * @param money 金额 （正数）
     * @param time 执行时间 "yyyy-MM-dd"
     * @param remark 备注
     * @return
     */
    @PostMapping("/transfer")
    @Transactional
    public Msg transfer(Integer assetsIdFrom,Integer assetsIdTo,BigDecimal money,String time,String remark){
        AssetsTransferRecord assetsTransferRecord = new AssetsTransferRecord(assetsIdFrom,assetsIdTo,money,time,remark,0,new Date());
        assetsTransferRecordService.save(assetsTransferRecord);

        Assets source = assetsService.get(assetsIdFrom);
        Assets asset = new Assets(assetsIdFrom,source.getMoney().subtract(money));
        UpdateTool.copyNullProperties(source,asset);
        assetsService.save(asset);
        source = assetsService.get(assetsIdTo);
        asset = new Assets(assetsIdTo,source.getMoney().add(money));
        UpdateTool.copyNullProperties(source,asset);
        assetsService.save(asset);
        return ResultUtil.success(assetsTransferRecord);
    }

    /**
     * 查询所有资产账户
     * @param asset
     * @return
     */
    @GetMapping("/list")
    public Msg list(Assets asset){
        List<Assets> list = assetsService.list(asset);
        return ResultUtil.success(list);
    }



    /**
     * 删除资产账户
     * @param id
     * @return
     */
    @DeleteMapping("/del")
    public Msg delete(Integer id){
        Assets a = new Assets(id,1);
        assetsService.update(a);
        return ResultUtil.success();
    }



}
