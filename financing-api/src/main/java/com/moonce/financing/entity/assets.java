package com.moonce.financing.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "assets")
public class assets {
    public assets() {
    }

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
    private Integer state;
    @Column(name = "remark")
    private String remark;
    @Column(name = "create_time")
    private Date create_time;
    @Column(name = "money")
    private BigDecimal money;
    @Column(name = "ranking")
    private Integer ranking;
    @Column(name = "init_money")
    private BigDecimal init_money;

    @Override
    public String toString() {
        return "assets{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imgName='" + imgName + '\'' +
                ", type=" + type +
                ", state=" + state +
                ", remark='" + remark + '\'' +
                ", create_time=" + create_time +
                ", money=" + money +
                ", ranking=" + ranking +
                ", init_money=" + init_money +
                '}';
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

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
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

    public BigDecimal getInit_money() {
        return init_money;
    }

    public void setInit_money(BigDecimal init_money) {
        this.init_money = init_money;
    }
}
