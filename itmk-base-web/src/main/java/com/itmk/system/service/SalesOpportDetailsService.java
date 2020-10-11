package com.itmk.system.service;

import com.itmk.system.entity.Salesopport;

import java.util.Map;

/**
 * 商机详情业务接口
 * @author 廖湘明
 * @data 2020/10/10 17:42
 * @return
 */
public interface SalesOpportDetailsService {
    //查找销售机会的所有信息（竞争对手、需求分析、报价单、解决方案）,客户的所有待办任务
    public Map querySalesOpportAndCustomeDetails(Integer soId);
    //刷新销售机会数据
    public Salesopport pushSalesOpport(Integer soId);
}
