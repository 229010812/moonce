package com.moonce.financing.controller;

import com.moonce.common.util.ResultUtil;
import com.moonce.common.util.UpdateTool;
import com.moonce.common.vo.Msg;
import com.moonce.financing.entity.Assets;
import com.moonce.financing.entity.AssetsModifyRecord;
import com.moonce.financing.entity.Record;
import com.moonce.financing.entity.vo.RecordVO;
import com.moonce.financing.service.AssetsService;
import com.moonce.financing.service.RecordService;
import com.moonce.financing.service.RecordTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;
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
        return ResultUtil.success(RecordVO.getList(list));
    }

    /**
     *  新增收支
     * @param
     * @return
     */
    @PostMapping("/add")
    public Msg add(BigDecimal money,
                   String remark,
                   String time,
                   Integer assetsId,
                   Integer recordTypeId){
        Record record = new Record(money,remark,time,new Date(),assetsId,recordTypeId);
        recordService.add(record);
        if(record.getAssets().getId() != null){
            Assets assets = assetsService.get(record.getAssets().getId());
            assets.setMoney(assets.getMoney().add(record.getMoney()));
            assetsService.save(assets);
        }
        return ResultUtil.success(record);
    }

    /**
     * 删除收支
     * @param id
     * @return
     */
    @DeleteMapping("/del")
    public Msg del(Integer id){
        Record record = recordService.get(id);
        if(record.getAssets().getId() != null){
            Assets assets = assetsService.get(record.getAssets().getId());
            assets.setMoney(assets.getMoney().subtract(record.getMoney()));
            assetsService.save(assets);
        }
        recordService.delete(id);
        return ResultUtil.success();
    }




}
