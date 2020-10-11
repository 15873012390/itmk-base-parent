package com.itmk.system.mapper;

import com.itmk.system.entity.Stagelog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 *功能描述 阶段日志持久层
 * @author 廖湘明
 * @date 2020/10/10
 */
public interface StagelogDao {

    public List<Stagelog> queryStageLogBySoid(@Param("soid") int soid);

    //删除销售机会时关联删除数据
    public void deleteStageLogBySoid(@Param("soId") int soid);

}
