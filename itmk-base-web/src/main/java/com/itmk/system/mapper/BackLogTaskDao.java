package com.itmk.system.mapper;

import com.itmk.system.entity.Backlogtask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 *功能描述 待办任务持久层接口
 * @author 廖湘明
 * @date 2020/10/10
 */
public interface BackLogTaskDao {

    public List<Backlogtask> queryAllByPage();

    public List<Backlogtask> queryLikeBackTaskLog(@Param("value") String value, @Param("inputs") String input,
                                                  @Param("select") String select);

    //public List<Backlogtask> queryAdvendceBackTaskLog(JrcBackLogTaskAdvancedSearch backLogTaskAdvancedSearch);

    public List<Backlogtask> queryBackLogTaskByCusId(Integer cusid);

    public Backlogtask queryBackLogTaskByBltId(Integer bltid);

    public Backlogtask delBackLogQuery(Integer bltid);

    public List<Backlogtask> queryCurMoth(@Param("startStr") Date startStr, @Param("end") Date end);

    public void deleteBackTaskBltId(@Param("bltid") Integer bltid);


    public List<Backlogtask> queryBakLogTaskDetailsByUidFinsh(@Param("op") Integer op, @Param("uid") Integer uid);

}