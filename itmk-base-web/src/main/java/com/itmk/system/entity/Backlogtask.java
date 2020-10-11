package com.itmk.system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.itmk.system.entity.jpa.JpaSysUser;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import com.itmk.system.entity.mybatis.Customer;
import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

/**
 *功能描述 待办任务实体类
 * @author 廖湘明
 * @date 2020/10/10
 */
@Entity
public class Backlogtask {
    private int bltId;
    private String bltDescription;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date finishDate;
    private Time finishTime;
    private Integer precedence;
    private String conName;
    private String conPhone;
    private Integer status;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp creationTime;
    private Integer delStatus;
    @JsonIgnoreProperties("backlogtask")
    private Customer customer;
    @JsonIgnoreProperties("backlogtask")
    private JpaSysUser user;
    @JsonIgnoreProperties("backlogtask")
    private List<Backlogtaskdetails> backlogtaskdetails;

    @Id
    @Column(name = "blt_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getBltId() {
        return bltId;
    }

    public void setBltId(int bltId) {
        this.bltId = bltId;
    }

    @Basic
    @Column(name = "blt_description")
    public String getBltDescription() {
        return bltDescription;
    }

    public void setBltDescription(String bltDescription) {
        this.bltDescription = bltDescription;
    }

    @Basic
    @Column(name = "finish_date")
    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    @Basic
    @Column(name = "finish_time")
    public Time getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Time finishTime) {
        this.finishTime = finishTime;
    }

    @Basic
    @Column(name = "precedence")
    public Integer getPrecedence() {
        return precedence;
    }

    public void setPrecedence(Integer precedence) {
        this.precedence = precedence;
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
    @Column(name = "con_phone")
    public String getConPhone() {
        return conPhone;
    }

    public void setConPhone(String conPhone) {
        this.conPhone = conPhone;
    }


    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "creation_time")
    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    @Basic
    @Column(name = "del_status")
    public Integer getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
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
    @JoinColumn(name="creator",referencedColumnName = "id")
    @NotFound(action = NotFoundAction.IGNORE)
    public JpaSysUser getUser() {
        return user;
    }

    public void setUser(JpaSysUser user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "backlogtask")
    public List<Backlogtaskdetails> getBacklogtaskdetails() {
        return backlogtaskdetails;
    }

    public void setBacklogtaskdetails(List<Backlogtaskdetails> backlogtaskdetails) {
        this.backlogtaskdetails = backlogtaskdetails;
    }
}
