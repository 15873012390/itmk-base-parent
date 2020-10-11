package com.itmk.system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.itmk.system.entity.jpa.JpaSysUser;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.sql.Timestamp;
/**
 *功能描述 待办任务详情实体类
 * @author 廖湘明
 * @date 2020/10/10
 */
@Entity
public class Backlogtaskdetails {
    private int btdId;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp finishTime;
    private int status;
    @JsonIgnoreProperties("backlogtaskdetails")
    private Backlogtask backlogtask;
    @JsonIgnoreProperties("backlogtaskdetails")
    private JpaSysUser user;

    @Id
    @Column(name = "btd_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getBtdId() {
        return btdId;
    }

    public void setBtdId(int btdId) {
        this.btdId = btdId;
    }


    @Basic
    @Column(name = "finish_time")
    public Timestamp getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Timestamp finishTime) {
        this.finishTime = finishTime;
    }

    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name="blt_id",referencedColumnName = "blt_id", nullable = false)
    public Backlogtask getBacklogtask() {
        return backlogtask;
    }

    public void setBacklogtask(Backlogtask backlogtask) {
        this.backlogtask = backlogtask;
    }

    @ManyToOne
    @JoinColumn(name="u_id",referencedColumnName = "id", nullable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    public JpaSysUser getUser() {
        return user;
    }

    public void setUser(JpaSysUser user) {
        this.user = user;
    }
}
