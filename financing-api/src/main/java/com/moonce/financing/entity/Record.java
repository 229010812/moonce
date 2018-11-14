package com.moonce.financing.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "f_record")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "roleSeq")
    @TableGenerator(name = "roleSeq", allocationSize = 1, table = "seq_table", pkColumnName = "seq_id", valueColumnName = "seq_count")
    @Column(name = "id")
    private Integer id;
    @Column(name = "money")
    private BigDecimal money;
    @Column(name = "remark")
    private String remark;
    @Column(name = "time")
    private Date time;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "assets_id")
    private Integer assetsId;
    @Column(name = "record_type_id")
    private Integer recordTypeId;

    public Record() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getAssetsId() {
        return assetsId;
    }

    public void setAssetsId(Integer assetsId) {
        this.assetsId = assetsId;
    }

    public Integer getRecordTypeId() {
        return recordTypeId;
    }

    public void setRecordTypeId(Integer recordTypeId) {
        this.recordTypeId = recordTypeId;
    }
}
