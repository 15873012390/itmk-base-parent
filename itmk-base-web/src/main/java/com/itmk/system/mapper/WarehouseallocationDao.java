package com.itmk.system.mapper;


import com.itmk.system.entity.Warehouseallocation;
import com.itmk.system.vo.WarehouseallocationAdvancedSearchVo;
import com.itmk.system.entity.Warehouseallocationdetail;

import java.util.List;

/**
 *功能描述 出库持久层接口
 * @author 廖湘明
 * @date 2020/9/21
 * @param
 * @return
 */
public interface WarehouseallocationDao {

    //查询所有调拨记录
    public List<Warehouseallocation> selectWaByPage();
    //通过下拉框搜索值查询所有记录列表
    public List<Warehouseallocation> queryBySelectAndInput(String value,String input,String select);
    //插入调拨记录
    public void insertWa(Warehouseallocation warehouseallocation);

    public void updateWa(Warehouseallocation warehouseallocation);
    //插入调拨记录详情
    public void insertWad(Warehouseallocationdetail warehouseallocationdetail);
    //修改调拨记录详情
    public void updateWad(Warehouseallocationdetail warehouseallocationdetail);
    //通过id查询调拨记录
    public Warehouseallocation queryWaByWaId(Integer waId);

    public List<Warehouseallocationdetail> queryWadByWaId(Integer wadId);

    //高级查询调拨记录
    public List<Warehouseallocation> queryByAdvanced(WarehouseallocationAdvancedSearchVo waad);
    //通过id删除调拨记录
    public void deleteWaByWaId(Integer waId);

    public void deleteWaByWaIdAndSpeId(Integer waId,Integer speId);

}
