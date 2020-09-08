package com.itmk.system.entity.mybatis;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.itmk.system.entity.jpa.JpaSysUser;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Customertransfer {
    private int ctId;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp ctTime;
    private Customer customer;
    @JsonIgnoreProperties("customertransfer3")
    private JpaSysUser user3;
    @JsonIgnoreProperties("customertransfer2")
    private JpaSysUser user2;
    @JsonIgnoreProperties("customertransfer1")
    private JpaSysUser user1;

    public Customertransfer() {
    }

    public Customertransfer(int ctId, Timestamp ctTime, Customer customer, JpaSysUser user3, JpaSysUser user2, JpaSysUser user1) {
        this.ctId = ctId;
        this.ctTime = ctTime;
        this.customer = customer;
        this.user3 = user3;
        this.user2 = user2;
        this.user1 = user1;
    }

    @Id
    @Column(name = "ct_id")
    public int getCtId() {
        return ctId;
    }

    public void setCtId(int ctId) {
        this.ctId = ctId;
    }

    @Basic
    @Column(name = "ct_time")
    public Timestamp getCtTime() {
        return ctTime;
    }

    public void setCtTime(Timestamp ctTime) {
        this.ctTime = ctTime;
    }


    @ManyToOne
    @JoinColumn(name="cus_id",referencedColumnName = "cus_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(name="original_u_id",referencedColumnName = "id")
    public JpaSysUser getUser3() {
        return user3;
    }

    public void setUser3(JpaSysUser user3) {
        this.user3 = user3;
    }

    @ManyToOne
    @JoinColumn(name="now_u_id",referencedColumnName = "id")
    public JpaSysUser getUser2() {
        return user2;
    }

    public void setUser2(JpaSysUser user2) {
        this.user2 = user2;
    }

    @ManyToOne
    @JoinColumn(name="operation_u_id",referencedColumnName = "id")
    public JpaSysUser getUser1() {
        return user1;
    }

    public void setUser1(JpaSysUser user1) {
        this.user1 = user1;
    }
}
