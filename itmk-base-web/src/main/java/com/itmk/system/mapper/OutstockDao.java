package com.itmk.system.mapper;


import com.itmk.system.entity.Outstock;
import com.itmk.system.entity.Outstockdetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface OutstockDao {

    public Outstock queryOutstockByOutId(Integer outId);

    public List<Outstock> queryAllOutstock();

    public void insertOutstock(Outstock outstock);

    public void updateOutStock(Outstock outstock);

    public void insertOutStockDetails(Outstockdetails outstockdetails);

    public List<Outstockdetails> queryAllOutdetailById(Integer outId);

    public void deleteOutstockByOutId(Integer outId);

    public void deleteOutstockDetailByOutId(Integer outId);

    public void deleteOutstockDetailByOutIdAndSpeId(Integer outId,Integer speId);

    public void updateOutDeatails(Outstockdetails outstockdetails);

    public List<Outstock> queryOutStockSelectAndInputByPage(String value,String input,String select);

    //public List<Outstock> queryoutStockByAdvancedSearch(OutStockAdvancedSearch oas);

    public Outstock queryOutstockByOrdId(Integer ordId);

    public Outstockdetails queryOsdByOutIdAndSpeId(Integer outId,Integer speId);

    public Integer queryNoOutstock(String uName);

    public List<Outstock> queryNoOutStockList(String uName);
}
