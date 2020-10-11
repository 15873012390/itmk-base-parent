package com.itmk.system.entity.mybatis;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.itmk.system.entity.*;
import com.itmk.system.entity.jpa.JpaSysUser;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Customer {
    private int cusId;
    @Excel(name="客户名称")
    private String cusName;
    @Excel(name="客户等级")
    private String cusLevel;
    @Excel(name="客户地址")
    private String cusAddr;
    @Excel(name="客户电话")
    private String cusTel;
    @Excel(name="客户来源")
    private String cusSource;
    @Excel(name = "创建时间", exportFormat = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp cusCreationTime;
    @Excel(name = "更新时间", exportFormat = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp cusUpdateTime;
    @Excel(name="信用等级")
    private String cusCredit;
    @Excel(name="邮编")
    private String cusZip;
    @Excel(name="传真")
    private String cusFax;
    @Excel(name="生命周期")
    private String cusLifeCycle;
    @Excel(name="国家或区域")
    private String cusCountry;
    @Excel(name="省份")
    private String cusProvince;
    @Excel(name="城市")
    private String cusCity;
    @Excel(name="区县")
    private String cusDistrict;
    @Excel(name="客户状态")
    private String cusState;
    @Excel(name="定级")
    private String cusGrading;
    @Excel(name="备注")
    private String cusRemarks;
    //用户
    private JpaSysUser jpaSysUser;
    //联系人表
    private List<Contacts> contacts;
    //销售机会表
    private List<Salesopport> salesopport;
    //报价表
    private List<Quote> quote;
    //待办任务表
    private List<Backlogtask> backlogtask;
    //订单表
    private List<Orders> orders;
    //订单明细表
    private List<Orderdetail> orderdetail;

    @Id
    @Column(name = "cus_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    @Basic
    @Column(name = "cus_name")
    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }


    @Basic
    @Column(name = "cus_level")
    public String getCusLevel() {
        return cusLevel;
    }

    public void setCusLevel(String cusLevel) {
        this.cusLevel = cusLevel;
    }

    @Basic
    @Column(name = "cus_addr")
    public String getCusAddr() {
        return cusAddr;
    }

    public void setCusAddr(String cusAddr) {
        this.cusAddr = cusAddr;
    }

    @Basic
    @Column(name = "cus_tel")
    public String getCusTel() {
        return cusTel;
    }

    public void setCusTel(String cusTel) {
        this.cusTel = cusTel;
    }

    @Basic
    @Column(name = "cus_source")
    public String getCusSource() {
        return cusSource;
    }

    public void setCusSource(String cusSource) {
        this.cusSource = cusSource;
    }

    @Basic
    @Column(name = "cus_creation_time")
    public Timestamp getCusCreationTime() {
        return cusCreationTime;
    }

    public void setCusCreationTime(Timestamp cusCreationTime) {
        this.cusCreationTime = cusCreationTime;
    }

    @Basic
    @Column(name = "cus_update_time")
    public Timestamp getCusUpdateTime() {
        return cusUpdateTime;
    }

    public void setCusUpdateTime(Timestamp cusUpdateTime) {
        this.cusUpdateTime = cusUpdateTime;
    }

    @Basic
    @Column(name = "cus_credit")
    public String getCusCredit() {
        return cusCredit;
    }

    public void setCusCredit(String cusCredit) {
        this.cusCredit = cusCredit;
    }

    @Basic
    @Column(name = "cus_zip")
    public String getCusZip() {
        return cusZip;
    }

    public void setCusZip(String cusZip) {
        this.cusZip = cusZip;
    }

    @Basic
    @Column(name = "cus_fax")
    public String getCusFax() {
        return cusFax;
    }

    public void setCusFax(String cusFax) {
        this.cusFax = cusFax;
    }

    @Basic
    @Column(name = "cus_life_cycle")
    public String getCusLifeCycle() {
        return cusLifeCycle;
    }

    public void setCusLifeCycle(String cusLifeCycle) {
        this.cusLifeCycle = cusLifeCycle;
    }

    @Basic
    @Column(name = "cus_country")
    public String getCusCountry() {
        return cusCountry;
    }

    public void setCusCountry(String cusCountry) {
        this.cusCountry = cusCountry;
    }

    @Basic
    @Column(name = "cus_province")
    public String getCusProvince() {
        return cusProvince;
    }

    public void setCusProvince(String cusProvince) {
        this.cusProvince = cusProvince;
    }

    @Basic
    @Column(name = "cus_city")
    public String getCusCity() {
        return cusCity;
    }

    public void setCusCity(String cusCity) {
        this.cusCity = cusCity;
    }

    @Basic
    @Column(name = "cus_district")
    public String getCusDistrict() {
        return cusDistrict;
    }

    public void setCusDistrict(String cusDistrict) {
        this.cusDistrict = cusDistrict;
    }

    @Basic
    @Column(name = "cus_state")
    public String getCusState() {
        return cusState;
    }

    public void setCusState(String cusState) {
        this.cusState = cusState;
    }

    @Basic
    @Column(name = "cus_grading")
    public String getCusGrading() {
        return cusGrading;
    }

    public void setCusGrading(String cusGrading) {
        this.cusGrading = cusGrading;
    }

    @Basic
    @Column(name = "cus_remarks")
    public String getCusRemarks() {
        return cusRemarks;
    }

    public void setCusRemarks(String cusRemarks) {
        this.cusRemarks = cusRemarks;
    }

    @ManyToOne
    @JoinColumn(name="u_id",referencedColumnName = "id")
    public JpaSysUser getJpaSysUser() {
        return jpaSysUser;
    }

    public void setJpaSysUser(JpaSysUser jpaSysUser) {
        this.jpaSysUser = jpaSysUser;
    }

    @OneToMany(mappedBy = "customer")
    public List<Contacts> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contacts> contacts) {
        this.contacts = contacts;
    }

    @OneToMany(mappedBy = "customer")
    public List<Salesopport> getSalesopport() {
        return salesopport;
    }

    public void setSalesopport(List<Salesopport> salesopport) {
        this.salesopport = salesopport;
    }
    @OneToMany(mappedBy = "customer")
    public List<Quote> getQuote() {
        return quote;
    }

    public void setQuote(List<Quote> quote) {
        this.quote = quote;
    }
    @OneToMany(mappedBy = "customer")
    public List<Backlogtask> getBacklogtask() {
        return backlogtask;
    }

    public void setBacklogtask(List<Backlogtask> backlogtask) {
        this.backlogtask = backlogtask;
    }

    @OneToMany(mappedBy = "customer")
    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @OneToMany(mappedBy = "customer")
    public List<Orderdetail> getOrderdetail() {
        return orderdetail;
    }

    public void setOrderdetail(List<Orderdetail> orderdetail) {
        this.orderdetail = orderdetail;
    }

    //    @OneToMany(mappedBy = "customer")
//    public List<Customerchurnwarning> getCustomerchurnwarning() {
//        return customerchurnwarning;
//    }
//
//    public void setCustomerchurnwarning(List<Customerchurnwarning> customerchurnwarning) {
//        this.customerchurnwarning = customerchurnwarning;
//    }

}
