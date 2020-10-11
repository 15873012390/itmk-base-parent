package com.itmk.system.controller;

import com.itmk.result.ResultUtils;
import com.itmk.result.ResultVo;
import com.itmk.system.service.SalesOpportDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 *功能描述 商机详情控制层
 * @author 廖湘明
 * @date 2020/10/10
 */
@RestController
@RequestMapping(value = "/api/salesOpportDetails")
public class SalesOpportDetailsController {
    @Autowired
    private SalesOpportDetailsService backLogTaskService;
    /**
     *功能描述 查询商机详情成功
     * @author 廖湘明
     * @date 2020/10/10
     * @param
     * @return
     */
    @GetMapping("/query_salesOpport_and_customer_details")
    public ResultVo querySalesOpportAndCustomeDetails(Integer soId){
        return ResultUtils.success("查询商机详情成功",this.backLogTaskService.querySalesOpportAndCustomeDetails(soId));
    }
    /**
     *功能描述 刷新商机详情成功
     * @author 廖湘明
     * @date 2020/10/10
     * @param
     * @return
     */
    @GetMapping("/push_salesOpport_by_soid")
    public ResultVo pushSalesOpport(Integer soId){
        return ResultUtils.success("刷新商机详情成功",this.backLogTaskService.pushSalesOpport(soId));
    }

    /*@GetMapping("/query_repair_all_by_cusid")
    public List<Repair> queryRepairAllByCusId(Integer cusid){
        return backLogTaskService.queryRepairAllByCusId(cusid);
    }*/
}
