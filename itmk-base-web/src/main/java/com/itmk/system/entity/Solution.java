package com.itmk.system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 *功能描述 解决方案
 * @author 廖湘明
 * @date 2020/10/10
 */
@Entity
public class Solution {
    private int solId;
    private String solTheme;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Timestamp submissionTime;
    private String solContent;
    private String feedback;
    @JsonIgnoreProperties("salesopport")
    private Salesopport salesopport;

    @Id
    @Column(name = "sol_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getSolId() {
        return solId;
    }

    public void setSolId(int solId) {
        this.solId = solId;
    }

    @Basic
    @Column(name = "sol_theme")
    public String getSolTheme() {
        return solTheme;
    }

    public void setSolTheme(String solTheme) {
        this.solTheme = solTheme;
    }

    @Basic
    @Column(name = "submission_time")
    public Timestamp getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(Timestamp submissionTime) {
        this.submissionTime = submissionTime;
    }

    @Basic
    @Column(name = "sol_content")
    public String getSolContent() {
        return solContent;
    }

    public void setSolContent(String solContent) {
        this.solContent = solContent;
    }

    @Basic
    @Column(name = "feedback")
    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @ManyToOne
    @JoinColumn(name="so_id",referencedColumnName = "so_id")
    public Salesopport getSalesopport() {
        return salesopport;
    }

    public void setSalesopport(Salesopport salesopport) {
        this.salesopport = salesopport;
    }
}
