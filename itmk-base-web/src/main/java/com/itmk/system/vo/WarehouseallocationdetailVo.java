package com.itmk.system.vo;


import com.itmk.system.entity.Warehouseallocationdetail;

import java.util.List;

/**
 *功能描述 库存详情vo
 * @author 廖湘明
 * @date 2020/9/24
 * @param
 * @return
 */
public class WarehouseallocationdetailVo {
    private List<Warehouseallocationdetail> list;
    private String uName;
    private List<Integer> delList;

    public List<Warehouseallocationdetail> getList() {
        return list;
    }

    public void setList(List<Warehouseallocationdetail> list) {
        this.list = list;
    }

    public List<Integer> getDelList() {
        return delList;
    }

    public void setDelList(List<Integer> delList) {
        this.delList = delList;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }
}
