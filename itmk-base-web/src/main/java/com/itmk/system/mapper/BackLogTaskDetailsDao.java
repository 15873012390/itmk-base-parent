package com.itmk.system.mapper;
import com.itmk.system.entity.Backlogtaskdetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *功能描述 待办任务详情持久层
 * @author 廖湘明
 * @date 2020/10/10
 */
public interface BackLogTaskDetailsDao {

    public List<Backlogtaskdetails> queryBackLogTaskUserBybltId(@Param("bltId") Integer bltId);

/*
    public List<Backlogtaskdetails> queryBakLogTaskDetailsByUidFinsh(@Param("op") Integer op,@Param("uid") Integer uid);
*/

}
