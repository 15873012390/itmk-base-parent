package com.itmk.system.entity.mybatis;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.itmk.system.entity.mybatis.Customer;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="contacts")//设置数据库中表名字
public class Contacts {
    private int conId;
    private String conName;
    private String conTel;
    private String conMobile;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp conTime;
    private String conSex;
    private String conPosition;
    private String conRemarks;
    private String conImg;
    @JsonIgnoreProperties("contacts")
    private Customer customer;

    @Id
    @Column(name = "con_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getConId() {
        return conId;
    }

    public void setConId(int conId) {
        this.conId = conId;
    }

    @Basic
    @Column(name = "con_name")
    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName;
    }

    @Basic
    @Column(name = "con_tel")
    public String getConTel() {
        return conTel;
    }

    public void setConTel(String conTel) {
        this.conTel = conTel;
    }

    @Basic
    @Column(name = "con_mobile")
    public String getConMobile() {
        return conMobile;
    }

    public void setConMobile(String conMobile) {
        this.conMobile = conMobile;
    }

    @Basic
    @Column(name = "con_time")
    public Timestamp getConTime() {
        return conTime;
    }

    public void setConTime(Timestamp conTime) {
        this.conTime = conTime;
    }

    @Basic
    @Column(name = "con_sex")
    public String getConSex() {
        return conSex;
    }

    public void setConSex(String conSex) {
        this.conSex = conSex;
    }

    @Basic
    @Column(name = "con_position")
    public String getConPosition() {
        return conPosition;
    }

    public void setConPosition(String conPosition) {
        this.conPosition = conPosition;
    }

    @Basic
    @Column(name = "con_remarks")
    public String getConRemarks() {
        return conRemarks;
    }

    @Basic
    @Column(name = "con_img")
    public String getConImg() {
        return conImg;
    }

    public void setConImg(String conImg) {
        this.conImg = conImg;
    }

    public void setConRemarks(String conRemarks) {
        this.conRemarks = conRemarks;
    }


    @ManyToOne
    @JoinColumn(name="cus_id",referencedColumnName = "cus_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
