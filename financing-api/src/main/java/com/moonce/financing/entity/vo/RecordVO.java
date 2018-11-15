package com.moonce.financing.entity.vo;

import com.moonce.financing.entity.Assets;
import com.moonce.financing.entity.Record;
import com.moonce.financing.entity.RecordType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class RecordVO  {

    private Integer id;

    private BigDecimal money;

    private String remark;

    private Date time;

    private Date createTime;

    private AssetsVO assets;

    private RecordTypeVO recordType;

    public RecordVO() {
    }

    public RecordVO(Record record) {
        this.id = record.getId();
        this.money = record.getMoney();
        this.remark = record.getRemark();
        this.time = record.getTime();
        this.createTime = record.getCreateTime();
        this.assets = new AssetsVO(record.getAssets());
//        this.recordType =new RecordTypeVO(record.getRecordType());
    }
    public static List<RecordVO> getList(List<Record> recordList){
        List<RecordVO> recordVOList=new ArrayList<>();
        RecordVO recordVO;
        for (Record record : recordList) {
            recordVO = new RecordVO(record);
            recordVOList.add(recordVO);
        }
        return recordVOList;
    }

    public RecordTypeVO getRecordType() {
        return recordType;
    }

    public void setRecordType(RecordTypeVO recordType) {
        this.recordType = recordType;
    }

    public AssetsVO getAssets() {
        return assets;
    }

    public void setAssets(AssetsVO assets) {
        this.assets = assets;
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


    class AssetsVO {
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
    class RecordTypeVO {
        private Integer id;
        private String name;
        private String imgName;
        private Integer type;
        private Integer ranking;
        private Integer state;

        public RecordTypeVO(RecordType recordType) {
            this.id = recordType.getId();
            this.name = recordType.getName();
            this.imgName = recordType.getImgName();
            this.type = recordType.getType();
            this.ranking = recordType.getRanking();
            this.state = recordType.getState();
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
}
