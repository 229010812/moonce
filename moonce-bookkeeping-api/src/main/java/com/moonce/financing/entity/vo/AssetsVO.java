package com.moonce.financing.entity.vo;

import com.moonce.financing.entity.Assets;
import com.moonce.financing.entity.Record;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 资产信息
 */
public class AssetsVO implements Serializable {
    private Integer id;
    private String name;
    private String imgName;
    private Integer type;
    private Integer state = 0;
    private String remark;
    private Date createTime;
    private BigDecimal money;
    private Integer ranking;
    private BigDecimal initMoney;
    private List<RecordVO> recordList;

    public AssetsVO(Assets assets) {
        this.id = assets.getId();
        this.name = assets.getName();
        this.imgName = assets.getImgName();
        this.type = assets.getType();
        this.state = assets.getState();
        this.remark = assets.getRemark();
        this.createTime = assets.getCreateTime();
        this.money = assets.getMoney();
        this.ranking = assets.getRanking();
        this.initMoney = assets.getMoney();
//        this.recordList = RecordVO.getList(assets.getRecordList());
    }



    public AssetsVO() {
    }

    @Override
    public String toString() {
        return "Assets{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imgName='" + imgName + '\'' +
                ", type=" + type +
                ", state=" + state +
                ", remark='" + remark + '\'' +
                ", create_time=" + createTime +
                ", money=" + money +
                ", ranking=" + ranking +
                ", init_money=" + initMoney +
                '}';
    }

    public List<RecordVO> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<RecordVO> recordList) {
        this.recordList = recordList;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public BigDecimal getInitMoney() {
        return initMoney;
    }

    public void setInitMoney(BigDecimal initMoney) {
        this.initMoney = initMoney;
    }
}
