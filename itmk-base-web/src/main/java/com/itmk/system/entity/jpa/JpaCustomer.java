package com.itmk.system.entity.jpa;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "customer", schema = "itmk-system", catalog = "")
public class JpaCustomer {
    private int cusId;
    private String cusName;
    private Integer uId;
    private String cusLevel;
    private String cusAddr;
    private String cusTel;
    private String cusSource;
    private Timestamp cusCreationTime;
    private Timestamp cusUpdateTime;
    private String cusCredit;
    private String cusZip;
    private String cusFax;
    private String cusLifeCycle;
    private String cusCountry;
    private String cusProvince;
    private String cusCity;
    private String cusDistrict;
    private String cusState;
    private String cusGrading;
    private String cusRemarks;

    @Id
    @Column(name = "cus_id")
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
    @Column(name = "u_id")
    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JpaCustomer that = (JpaCustomer) o;
        return cusId == that.cusId &&
                Objects.equals(cusName, that.cusName) &&
                Objects.equals(uId, that.uId) &&
                Objects.equals(cusLevel, that.cusLevel) &&
                Objects.equals(cusAddr, that.cusAddr) &&
                Objects.equals(cusTel, that.cusTel) &&
                Objects.equals(cusSource, that.cusSource) &&
                Objects.equals(cusCreationTime, that.cusCreationTime) &&
                Objects.equals(cusUpdateTime, that.cusUpdateTime) &&
                Objects.equals(cusCredit, that.cusCredit) &&
                Objects.equals(cusZip, that.cusZip) &&
                Objects.equals(cusFax, that.cusFax) &&
                Objects.equals(cusLifeCycle, that.cusLifeCycle) &&
                Objects.equals(cusCountry, that.cusCountry) &&
                Objects.equals(cusProvince, that.cusProvince) &&
                Objects.equals(cusCity, that.cusCity) &&
                Objects.equals(cusDistrict, that.cusDistrict) &&
                Objects.equals(cusState, that.cusState) &&
                Objects.equals(cusGrading, that.cusGrading) &&
                Objects.equals(cusRemarks, that.cusRemarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cusId, cusName, uId, cusLevel, cusAddr, cusTel, cusSource, cusCreationTime, cusUpdateTime, cusCredit, cusZip, cusFax, cusLifeCycle, cusCountry, cusProvince, cusCity, cusDistrict, cusState, cusGrading, cusRemarks);
    }
}
