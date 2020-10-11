package com.itmk.system.mapper;

import com.itmk.system.entity.Clientdemand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *功能描述  客户需求持久层
 * @author 廖湘明
 * @date 2020/10/10
 */
public interface ClientdemandDao {

    public List<Clientdemand> queryAllClientDemand();

    public Clientdemand queryClientDemandByCdId(@Param("cdId") Integer cdId);

    public List<Clientdemand> queryClientDemandByLike(@Param("value") String value, @Param("inputs") String input);

    //public List<Clientdemand> queryClientDemandAdvenced(JrcClientDemandAdvancedSearch clientDemandAdvancedSearch);

    public List<Clientdemand> queryClientdemandBySoid(@Param("soId") Integer soId);


    //删除销售机会时关联删除数据
    public void deleteClientdemandBySoid(@Param("soId") Integer soId);



}
