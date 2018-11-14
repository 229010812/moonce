package com.moonce.financing.controller;

import com.moonce.common.util.ResultUtil;
import com.moonce.common.util.UpdateTool;
import com.moonce.common.vo.Msg;
import com.moonce.financing.entity.Assets;
import com.moonce.financing.entity.AssetsModifyRecord;
import com.moonce.financing.entity.Record;
import com.moonce.financing.service.AssetsService;
import com.moonce.financing.service.RecordService;
import com.moonce.financing.service.RecordTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/record")
public class RecordController {
    @Autowired
    private RecordTypeService recordTypeService;
    @Autowired
    private AssetsService assetsService;

    @Autowired
    private RecordService recordService;

    @GetMapping("/list")
    public Msg list(Record record){
        List<Record> list = recordService.list(record);
        return ResultUtil.success(list);
    }

    /**
     *  新增收支
     * @param  record
     * @return
     */
    @PostMapping("/add")
    public Msg add(Record record){
        recordService.add(record);
        if(record.getAssetsId() != null){
            Assets assets = assetsService.get(record.getAssetsId());
            assets.setMoney(assets.getMoney().add(record.getMoney()));
            assetsService.save(assets);
        }
        return ResultUtil.success();
    }

    /**
     * 删除收支
     * @param id
     * @return
     */
    @DeleteMapping("/del")
    public Msg del(Integer id){
        Record record = recordService.get(id);
        if(record.getAssetsId() != null){
            Assets assets = assetsService.get(record.getAssetsId());
            assets.setMoney(assets.getMoney().add(record.getMoney().multiply(new BigDecimal(-1))));
            assetsService.save(assets);
        }
        recordService.delete(id);
        return ResultUtil.success();
    }




}
