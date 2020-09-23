package com.itmk.system.vo;

import java.util.Date;

/**
 * @author HYJ
 * @description
 * @Date 2020/9/22
 */
public class CrmoalogSearchVo {
    /**
     *功能描述
     *员工名
     */
    private String userName;

    private String starDate;

    private String endDate;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStarDate() {
        return starDate;
    }

    public void setStarDate(String starDate) {
        this.starDate = starDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
