package com.itmk.system.entity.jpa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.itmk.system.entity.mybatis.Customer;
import com.itmk.system.entity.mybatis.Customertransfer;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "sys_user", schema = "itmk-system", catalog = "")
public class JpaSysUser {
    private long id;
    private String username;
    private String password;
    private Integer isAccountNonExpired;
    private Integer isAccountNonLocked;
    private Integer isCredentialsNonExpired;
    private Integer isEnabled;
    private String nickName;
    private String deptId;
    private String deptName;
    private String mobile;
    private String email;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String loginName;
    private String isAdmin;
    private String sex;
    private String conImg;
    private List<Customer> customer;
    @JsonIgnoreProperties("user3")
    private List<Customertransfer> customertransfer3;
    @JsonIgnoreProperties("user2")
    private List<Customertransfer> customertransfer2;
    @JsonIgnoreProperties("user1")
    private List<Customertransfer> customertransfer1;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "is_account_non_expired")
    public Integer getIsAccountNonExpired() {
        return isAccountNonExpired;
    }

    public void setIsAccountNonExpired(Integer isAccountNonExpired) {
        this.isAccountNonExpired = isAccountNonExpired;
    }

    @Basic
    @Column(name = "is_account_non_locked")
    public Integer getIsAccountNonLocked() {
        return isAccountNonLocked;
    }

    public void setIsAccountNonLocked(Integer isAccountNonLocked) {
        this.isAccountNonLocked = isAccountNonLocked;
    }

    @Basic
    @Column(name = "is_credentials_non_expired")
    public Integer getIsCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public void setIsCredentialsNonExpired(Integer isCredentialsNonExpired) {
        this.isCredentialsNonExpired = isCredentialsNonExpired;
    }

    @Basic
    @Column(name = "is_enabled")
    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }

    @Basic
    @Column(name = "nick_name")
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Basic
    @Column(name = "dept_id")
    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    @Basic
    @Column(name = "dept_name")
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Basic
    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "login_name")
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Basic
    @Column(name = "is_admin")
    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "con_img")
    public String getConImg() {
        return conImg;
    }

    public void setConImg(String conImg) {
        this.conImg = conImg;
    }

    @OneToMany(mappedBy = "jpaSysUser")
    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }


    @OneToMany(mappedBy = "user3")
    public List<Customertransfer> getCustomertransfer3() {
        return customertransfer3;
    }

    public void setCustomertransfer3(List<Customertransfer> customertransfer3) {
        this.customertransfer3 = customertransfer3;
    }

    @OneToMany(mappedBy = "user2")
    public List<Customertransfer> getCustomertransfer2() {
        return customertransfer2;
    }

    public void setCustomertransfer2(List<Customertransfer> customertransfer2) {
        this.customertransfer2 = customertransfer2;
    }

    @OneToMany(mappedBy = "user1")
    public List<Customertransfer> getCustomertransfer1() {
        return customertransfer1;
    }

    public void setCustomertransfer1(List<Customertransfer> customertransfer1) {
        this.customertransfer1 = customertransfer1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JpaSysUser that = (JpaSysUser) o;
        return id == that.id &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(isAccountNonExpired, that.isAccountNonExpired) &&
                Objects.equals(isAccountNonLocked, that.isAccountNonLocked) &&
                Objects.equals(isCredentialsNonExpired, that.isCredentialsNonExpired) &&
                Objects.equals(isEnabled, that.isEnabled) &&
                Objects.equals(nickName, that.nickName) &&
                Objects.equals(deptId, that.deptId) &&
                Objects.equals(deptName, that.deptName) &&
                Objects.equals(mobile, that.mobile) &&
                Objects.equals(email, that.email) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(loginName, that.loginName) &&
                Objects.equals(isAdmin, that.isAdmin) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(conImg, that.conImg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, isAccountNonExpired, isAccountNonLocked, isCredentialsNonExpired, isEnabled, nickName, deptId, deptName, mobile, email, createTime, updateTime, loginName, isAdmin, sex, conImg);
    }
}
