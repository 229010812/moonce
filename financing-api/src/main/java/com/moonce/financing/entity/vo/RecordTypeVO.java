package com.moonce.financing.entity.vo;

import com.moonce.financing.entity.Record;
import com.moonce.financing.entity.RecordType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public class RecordTypeVO implements Serializable {
    private Integer id;
    private String name;
    private String imgName;
    private Integer type;
    private Integer ranking;
    private Integer state;
    private List<RecordVO> recordList;

    public RecordTypeVO(RecordType recordType) {
        this.id = recordType.getId();
        this.name = recordType.getName();
        this.imgName = recordType.getImgName();
        this.type = recordType.getType();
        this.ranking = recordType.getRanking();
        this.state = recordType.getState();
        this.recordList = RecordVO.getList(recordType.getRecordList());
    }

    public List<RecordVO> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<RecordVO> recordList) {
        this.recordList = recordList;
    }

    public RecordTypeVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
