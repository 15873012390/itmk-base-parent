package com.itmk.system.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itmk.system.entity.Salesopport;
import com.itmk.system.entity.mybatis.Customer;
import com.itmk.system.vo.SalesOpportAdvancedSearchVo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 *功能描述 销售机会业务接口
 * @author 廖湘明
 * @date 2020/10/10
 */
public interface SalesopportService {
    //查看所有
    public List<Salesopport> queryAll();
    //分页查看全部
    public Map queryAllSalesOppoerByPage(Integer currentPage, Integer pageSize);
    //模糊搜索
    public Map querySalesOpportByLikeSearchPage(String value, String inputs, String select, Integer currentPage, Integer pageSize);
    //高级搜索员工
    public Map querySalesOpportByAdvancedSearch(SalesOpportAdvancedSearchVo s);
    //添加/编辑商机
    public void addSalesOpport(Salesopport s);
    //根据商机id查找商机和销售阶段日志
    public Salesopport queryBySoid(Integer soid);
    //删除商机
    public void delSalesOpport(Integer soid);
    //批量删除销售机会
    public void delBatchSalesopport(Integer[] soids);
    //根据客户找到对应的销售机会
    public List<Salesopport> querySalesOpportByCustomer(Customer customer);
}
