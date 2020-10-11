package com.itmk.system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Stagelog {
    private int slId;
    private String slNote;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp recordTime;
    private String stageName;
    private String nickName;
    private Salesopport salesopport;

    @Id
    @Column(name = "sl_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getSlId() {
        return slId;
    }

    public void setSlId(int slId) {
        this.slId = slId;
    }

    @Basic
    @Column(name = "sl_note")
    public String getSlNote() {
        return slNote;
    }

    public void setSlNote(String slNote) {
        this.slNote = slNote;
    }

    @Basic
    @Column(name = "record_time")
    public Timestamp getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Timestamp recordTime) {
        this.recordTime = recordTime;
    }

    @Basic
    @Column(name = "stage_name")
    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }



    @Basic
    @Column(name = "nick_name")
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @ManyToOne
    @JoinColumn(name="so_id",referencedColumnName = "so_id")
    public Salesopport getSalesopport() {
        return salesopport;
    }

    public void setSalesopport(Salesopport salesopport) {
        this.salesopport = salesopport;
    }

    public Stagelog() {
    }

}
