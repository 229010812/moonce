package com.moonce.financing.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "f_assets_modify_record")
public class AssetsModifyRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "roleSeq")
    @TableGenerator(name = "roleSeq", allocationSize = 1, table = "seq_table", pkColumnName = "seq_id", valueColumnName = "seq_count")
    @Column(name = "id")
    private Integer id;

    @Column(name = "state")
    private Integer state;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "assets_id")
    private Integer assetsId;

    @Column(name = "money_before")
    private BigDecimal moneyBefore;

    @Column(name = "money")
    private BigDecimal money;

    public AssetsModifyRecord() {
    }

    public AssetsModifyRecord(Integer assetsId, BigDecimal moneyBefore, BigDecimal money) {
        this.assetsId = assetsId;
        this.moneyBefore = moneyBefore;
        this.money = money;
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

    public Integer getAssetsId() {
        return assetsId;
    }

    public void setAssetsId(Integer assetsId) {
        this.assetsId = assetsId;
    }

    public BigDecimal getMoneyBefore() {
        return moneyBefore;
    }

    public void setMoneyBefore(BigDecimal moneyBefore) {
        this.moneyBefore = moneyBefore;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
