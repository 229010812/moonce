package com.moonce.bookkeeping.controller;

import com.moonce.common.util.ResultUtil;
import com.moonce.common.util.UpdateTool;
import com.moonce.common.vo.Msg;
import com.moonce.bookkeeping.entity.Label;
import com.moonce.bookkeeping.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/label")
public class LabelController {
    @Autowired
    private LabelService labelService;

    @GetMapping("/list")
    public Msg list(Label label){
        List<Label> labelList = labelService.list(label);
        return ResultUtil.success(labelList);
    }

    @PostMapping("/add")
    public Msg add(Label label){
        label.setCreateTime(new Date());
        labelService.save(label);
        return ResultUtil.success();
    }

    @PutMapping("/update")
    public Msg update(Label label){
        Label source = labelService.get(label.getId());
        UpdateTool.copyNullProperties(source,label);
        labelService.save(label);
        return ResultUtil.success();
    }
}
