package com.moonce.bookkeeping.entity;

import com.moonce.common.constant.Code;
import com.moonce.common.util.CommonUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "f_assets_transfer_record")
public class AssetsTransferRecord  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "roleSeq")
    @TableGenerator(name = "roleSeq", allocationSize = 1, table = "seq_table", pkColumnName = "seq_id", valueColumnName = "seq_count")
    @Column(name = "id")
    private Integer id;
    @Column(name = "state")
    private Integer state;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "time")
    private Date time;
    @Column(name = "assets_id_form")
    private Integer assetsIdFrom;
    @Column(name = "assets_id_to")
    private Integer assetsIdTo;
    @Column(name = "remark")
    private String remark;
    @Column(name = "money")
    private BigDecimal money;

    public AssetsTransferRecord() {
    }

    public AssetsTransferRecord(Integer assetsIdFrom, Integer assetsIdTo, String money,String time,  String remark) {
        this.time = CommonUtils.isNullOrEmpty(time)?new Date():CommonUtils.stringCastToDate(time, Code.YYYY_MM_DD);
        this.assetsIdFrom = assetsIdFrom;
        this.assetsIdTo = assetsIdTo;
        this.remark = remark;
        this.money = new BigDecimal(money);
    }
    public AssetsTransferRecord(Integer assetsIdFrom, Integer assetsIdTo, BigDecimal money,String time,  String remark,Integer state,Date createTime) {
        this.time = CommonUtils.isNullOrEmpty(time)?new Date():CommonUtils.stringCastToDate(time, Code.YYYY_MM_DD);
        this.assetsIdFrom = assetsIdFrom;
        this.assetsIdTo = assetsIdTo;
        this.remark = remark;
        this.money = money;
        this.state = state;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getAssetsIdFrom() {
        return assetsIdFrom;
    }

    public void setAssetsIdFrom(Integer assetsIdFrom) {
        this.assetsIdFrom = assetsIdFrom;
    }

    public Integer getAssetsIdTo() {
        return assetsIdTo;
    }

    public void setAssetsIdTo(Integer assetsIdTo) {
        this.assetsIdTo = assetsIdTo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}