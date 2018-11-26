package com.moonce.bookkeeping.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "f_record_type")
public class RecordType implements Serializable {
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
    @Column(name = "ranking")
    private Integer ranking;
    @Column(name = "state")
    private Integer state;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="recordTypeId1",referencedColumnName = "id")
    private List<Record> recordList;

    public List<Record> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<Record> recordList) {
        this.recordList = recordList;
    }

    public RecordType() {
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
