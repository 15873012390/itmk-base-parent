package com.itmk.system.mapper;


import com.itmk.system.entity.Instock;
import com.itmk.system.entity.Instockdetail;
import com.itmk.system.vo.InstockAdvancedSearchVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface InstockDao {

    public List<Instock> queryByWhId(String warehouseId);
    //查询所有入库
    public List<Instock> selectAllInstock();
    //添加入库
    public void insertInstock(Instock instock);
    //通过id查询入库
    public Instock queryByInsId(Integer insId);

    public void updateInstock(Instock instock);

    public void deleteInstockById(Integer insId);

    public void deleteInstockDetailById(Integer insId);

    public void deleteInstockDetailBySpeIdAndInsId(Integer speId,Integer insId);

    //通过下拉框数据查询入库
    public List<Instock> querySelectAndInputByPage(String value, String input, String select);
    //高级查询
    public List<Instock> queryInstockByAdvancedSearch(InstockAdvancedSearchVo iad);

    public List<Instockdetail> queryInstockDetailByInsId(Integer insId);

    public void insertInstockDetail(Instockdetail insd);

    public void updateInstockDetail(Instockdetail insd);

    public Instockdetail queryInsdByInsIdAndSpeId(Integer insId,Integer speId);

    public Integer queryNoInstock(String uName);

    public List<Instock> queryNoInstockList(String uName);
}
