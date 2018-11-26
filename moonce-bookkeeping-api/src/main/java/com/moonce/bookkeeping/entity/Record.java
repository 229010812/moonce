package com.moonce.bookkeeping.entity;

import com.moonce.common.constant.Code;
import com.moonce.common.util.CommonUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "f_record")
public class Record  implements Serializable {
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


    @OneToOne
    @JoinColumn(name="assetsId")
    private Assets assets;

    @OneToOne
    @JoinColumn(name = "recordTypeId")
    private RecordType recordType;

    public Record() {
    }

    public Record(BigDecimal money, String remark, String time, Date createTime, Integer assetsId, Integer recordTypeId) {
        this.money = money;
        this.remark = remark;
        this.time = CommonUtils.stringCastToDate(time, Code.YYYY_MM_DD);
        this.createTime = createTime;
        Assets assets = new Assets();
        assets.setId(assetsId);
        this.assets=assets;
        RecordType recordType = new RecordType();
        recordType.setId(recordTypeId);
        this.recordType=recordType;
    }

    public Assets getAssets() {
        return assets;
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    public RecordType getRecordType() {
        return recordType;
    }

    public void setRecordType(RecordType recordType) {
        this.recordType = recordType;
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
}
