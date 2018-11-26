package com.moonce.financing.controller;

import com.moonce.common.util.ResultUtil;
import com.moonce.common.vo.Msg;
import com.moonce.financing.entity.RecordType;
import com.moonce.financing.service.RecordTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/record-type")
public class RecordTypeController {
    @Autowired
    private RecordTypeService recordTypeService;

    @GetMapping("/list")
    public Msg list(RecordType recordType){
        List<RecordType> labelList = recordTypeService.list(recordType);
        return ResultUtil.success(labelList);
    }

    @GetMapping("/page")
    public Msg page(RecordType recordType,Integer pageNum,Integer pageSize){
        Sort sort = new Sort(Sort.Direction.ASC,"ranking");
        Pageable pageable = PageRequest.of(pageNum-1,pageSize,sort);
        Page<RecordType> page = recordTypeService.page(recordType,pageable);
        return ResultUtil.success(page);
    }

    @PostMapping("/add")
    public Msg add(RecordType recordType){
        recordTypeService.save(recordType);
        return ResultUtil.success();
    }
}
