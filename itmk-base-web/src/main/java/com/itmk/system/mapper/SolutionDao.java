package com.itmk.system.mapper;

import com.itmk.system.entity.Solution;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 *功能描述 解决方案持久层接口
 * @author 廖湘明
 * @date 2020/10/10
 */
public interface SolutionDao {

    public List<Solution> querySolutionAllByPage();

    public List<Solution> querySolutionByLike(@Param("inputs") String inputs);

    //public List<Solution> querySolutionAdvenceSearch(JrcSolutionAdvenceSearch solutionAdvenceSearch);

    public Solution querySolutionById(@Param("solId") Integer solId);

    public List<Solution> querySolutionBySoid(@Param("soId") Integer soId);

    //删除销售机会关联删除数据
    public void deleteSolutionBySoid(@Param("soId") Integer soId);

    //属性解决方案数据
    public List<Solution> flashSolutionBySoid(@Param("soId") Integer soId);
}
