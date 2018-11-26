package com.moonce.bookkeeping.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 资产信息
 */
@Entity(name = "f_assets")
public class Assets implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "roleSeq")
    @TableGenerator(name = "roleSeq", allocationSize = 1, table = "seq_table", pkColumnName = "seq_id", valueColumnName = "seq_count")
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "img_name")
    private String imgName;
    @Column(name = "type")
    private Integer type;
    @Column(name = "state")
    private Integer state = 0;
    @Column(name = "remark")
    private String remark;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "money")
    private BigDecimal money;
    @Column(name = "ranking")
    private Integer ranking;
    @Column(name = "init_money")
    private BigDecimal initMoney;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="assetsId",referencedColumnName = "id")
    private List<Record> recordList;

    public Assets(Integer id, BigDecimal money) {
        this.id = id;
        this.money = money;
    }
    public Assets(Integer id, Integer state) {
        this.id = id;
        this.state = state;
    }

    public Assets() {
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

    public List<Record> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<Record> recordList) {
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
