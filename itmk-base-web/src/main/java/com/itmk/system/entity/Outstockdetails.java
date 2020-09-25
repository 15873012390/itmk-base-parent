package com.itmk.system.entity;

import javax.persistence.*;

@Entity
public class Outstockdetails {
    private int osdId;
    private Integer osdNumber;
    private String status;
    private String remarks;
    private Productspecification productspecification;
    private Outstock outstock;

    @Id
    @Column(name = "osd_id")
    public int getOsdId() {
        return osdId;
    }

    public void setOsdId(int osdId) {
        this.osdId = osdId;
    }

    @Basic
    @Column(name = "osd_number")
    public Integer getOsdNumber() {
        return osdNumber;
    }

    public void setOsdNumber(Integer osdNumber) {
        this.osdNumber = osdNumber;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Basic
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @ManyToOne
    @JoinColumn(name="spe_id",referencedColumnName = "spe_id")
    public Productspecification getProductspecification() {
        return productspecification;
    }

    public void setProductspecification(Productspecification productspecification) {
        this.productspecification = productspecification;
    }

    @ManyToOne
    @JoinColumn(name="out_id",referencedColumnName = "out_id")
    public Outstock getOutstock() {
        return outstock;
    }

    public void setOutstock(Outstock outstock) {
        this.outstock = outstock;
    }


    @Override
    public String toString() {
        return "Outstockdetails{" +
                "osdId=" + osdId +
                ", osdNumber=" + osdNumber +
                ", status='" + status + '\'' +
                ", remarks='" + remarks + '\'' +
                ", productspecification=" + productspecification +
                ", outstock=" + outstock +
                '}';
    }
}
