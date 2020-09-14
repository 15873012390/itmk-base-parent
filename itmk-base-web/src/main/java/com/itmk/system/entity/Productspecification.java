package com.itmk.system.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Productspecification {
    private int speId;
    private String proName;
    private String speSpecification;
    private String speUnit;
    private Integer speUnitConversion;
    private Product product;
    private List<Stock> stocks;

    @Id
    @Column(name = "spe_id")
    public int getSpeId() {
        return speId;
    }

    public void setSpeId(int speId) {
        this.speId = speId;
    }

    @Basic
    @Column(name = "pro_name")
    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    @Basic
    @Column(name = "spe_specification")
    public String getSpeSpecification() {
        return speSpecification;
    }

    public void setSpeSpecification(String speSpecification) {
        this.speSpecification = speSpecification;
    }

    @Basic
    @Column(name = "spe_unit")
    public String getSpeUnit() {
        return speUnit;
    }

    public void setSpeUnit(String speUnit) {
        this.speUnit = speUnit;
    }

    @Basic
    @Column(name = "spe_unit_conversion")
    public Integer getSpeUnitConversion() {
        return speUnitConversion;
    }

    public void setSpeUnitConversion(Integer speUnitConversion) {
        this.speUnitConversion = speUnitConversion;
    }

    @ManyToOne
    @JoinColumn(name="pro_id",referencedColumnName = "pro_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @OneToMany(mappedBy = "productspecification",cascade = CascadeType.ALL)
    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }
    @Override
    public String toString() {
        return "Productspecification{" +
                "speId=" + speId +
                ", proName='" + proName + '\'' +
                ", speSpecification='" + speSpecification + '\'' +
                ", speUnit='" + speUnit + '\'' +
                ", speUnitConversion=" + speUnitConversion +
                '}';
    }
}
