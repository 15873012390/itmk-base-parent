package com.itmk.system.vo;

import java.util.List;

/**
 *功能描述 库存数量Vo
 * @author 廖湘明
 * @date 2020/9/23
 * @param
 * @return
 */
public class StockNumberVo {
    private String proName;
    private List pnumber;
    private Integer dnumber;

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public List getPnumber() {
        return pnumber;
    }

    public void setPnumber(List pnumber) {
        this.pnumber = pnumber;
    }

    public Integer getDnumber() {
        return dnumber;
    }

    public void setDnumber(Integer dnumber) {
        this.dnumber = dnumber;
    }
}
