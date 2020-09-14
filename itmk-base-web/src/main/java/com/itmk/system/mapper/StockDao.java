package com.itmk.system.mapper;

import com.itmk.system.entity.Stock;

import com.itmk.system.vo.CountPieVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface StockDao {
    //查询所有库存
    public List<Stock> queryAllStock();
    //产品详情页上 统计每个仓库还有多少库存
    public List<CountPieVo> queryByStock();

}
