package com.itmk.system.entity;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSONArray;
import com.itmk.system.entity.jpa.JpaSysUser;

import javax.persistence.*;

/**
 * noties
 * @author 
 */
@Entity
public class Noties implements Serializable {
    /**
     * 公告Id
     */
    private Integer msgId;

    /**
     * 公告标题
     */
    private String title;

    /**
     * 公告内容
     */
    private String message;
    /**
     * 部门
     */
//    多对多 连表部门
    private JSONArray deptId;

    /**
     * 通知人
     */
    private String departId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 开始日期
     */
    private Date startDate;

    /**
     * 结束日期
     */
    private Date endDate;

    /**
     * 已读用户
     */
    private String readUserIds;
    /**
     * 创建人ID
     */
    private JpaSysUser createUser;
    /**
     * 公告状态
     */
    private  int state;

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "msgId")
    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

//    @ManyToMany
//    @JoinColumn(name="dept_id",referencedColumnName = "id")
//    public List<Department> getNotiesDept() {
//        return notiesDept;
//    }
//
//    public void setNotiesDept(List<Department> notiesDept) {
//        notiesDept = notiesDept;
//    }


    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getReadUserIds() {
        return readUserIds;
    }

    public void setReadUserIds(String readUserIds) {
        this.readUserIds = readUserIds;
    }

    @ManyToOne
    @JoinColumn(name = "create_user_id", referencedColumnName = "id")
//    noties 和 sys_user 共同字段关联，JoinColumn注解需要加到主表上
    public JpaSysUser getCreateUser() {
        return createUser;
    }

    public void setCreateUser(JpaSysUser createUser) {
        this.createUser = createUser;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public JSONArray getDeptId() {
        return deptId;
    }

    public void setDeptId(JSONArray deptId) {
        this.deptId = deptId;
    }


    public Noties() {
    }

    @Override
    public String toString() {
        return "Noties{" +
                "msgId=" + msgId +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", deptId=" + deptId +
                ", departId='" + departId + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", readUserIds='" + readUserIds + '\'' +
                ", createUser=" + createUser +
                ", state=" + state +
                '}';
    }

    public Noties(Integer msgId, String title, String message, JSONArray deptId, String departId, Date createTime, Date updateTime, Date startDate, Date endDate, String readUserIds, JpaSysUser createUser, int state) {
        this.msgId = msgId;
        this.title = title;
        this.message = message;
        this.deptId = deptId;
        this.departId = departId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.readUserIds = readUserIds;
        this.createUser = createUser;
        this.state = state;
    }
}