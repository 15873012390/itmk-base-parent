package com.itmk.system.controller;

import com.itmk.result.ResultUtils;
import com.itmk.result.ResultVo;
import com.itmk.system.entity.Salesopport;
import com.itmk.system.entity.mybatis.Customer;
import com.itmk.system.service.SalesopportService;
import com.itmk.system.vo.SalesOpportAdvancedSearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 *功能描述 商机列表控制层
 * @author 廖湘明
 * @date 2020/10/10
 */
@RestController
@RequestMapping(value = "/api/salesOpport")
public class SalesOpportController {
    @Autowired
    private SalesopportService salesopportService;

    /**
     *功能描述 查询所有
     * @author 廖湘明
     * @date 2020/10/10
     * @param
     * @return
     */
    @GetMapping("/query_all")
    public ResultVo queryAll(){
        return ResultUtils.success("查询商机列表成功",this.salesopportService.queryAll());
    }
    /**
     *功能描述 查询所有分页
     * @author 廖湘明
     * @date 2020/10/10
     * @param
     * @return
     */
    @GetMapping("/query_salesopport_by_page")
    public ResultVo querySalesopportByPage(Integer currentPage, Integer pageSize){
        return ResultUtils.success("查询所有分页成功",this.salesopportService.queryAllSalesOppoerByPage(currentPage,pageSize));
    }

    /**
     *功能描述 通过模糊搜索查询商机列表
     * @author 廖湘明
     * @date 2020/10/10
     * @param
     * @return
     */
    @GetMapping("/query_salesopport_by_like_page")
    public ResultVo querySalesopportByLikePage(String value,String input,String select,Integer currentPage, Integer pageSize){
        return ResultUtils.success("通过模糊搜索查询商机列表",this.salesopportService.querySalesOpportByLikeSearchPage(value, input, select, currentPage,pageSize));
    }
    /**
     *功能描述 高级查询
     * @author 廖湘明
     * @date 2020/10/10
     * @param
     * @return
     */
    @PostMapping("/query_salesopport_by_advanced_search")
    public ResultVo querySalesopportByAdvancedSearch(@RequestBody SalesOpportAdvancedSearchVo salesOpportAdvancedSearchVo){
        return ResultUtils.success("通过模糊搜索查询商机列表",this.salesopportService.querySalesOpportByAdvancedSearch(salesOpportAdvancedSearchVo));
    }

    /**、
     * 新增或编辑商机
     * @param salesopport
     * @return
     */
    @PostMapping("/add_salesopport")
    public ResultVo addSalesOpport(@RequestBody Salesopport salesopport){
        this.salesopportService.addSalesOpport(salesopport);
        return ResultUtils.success("新增或编辑商机");
    }

    /**
     *功能描述 通过id查询商机
     * @author 廖湘明
     * @date 2020/10/10
     * @param
     * @return
     */
    @GetMapping("/query_by_soid")
    public ResultVo queryBySoid(Integer soid){
        return ResultUtils.success("通过id查询商机",this.salesopportService.queryBySoid(soid));
    }

    /**
     *功能描述 批量删除商机
     * @author 廖湘明
     * @date 2020/10/10
     * @param
     * @return
     */
    @DeleteMapping("/del_salesopport")
    public ResultVo delSalesOpport( Integer soid){
        this.salesopportService.delSalesOpport(soid);
        return ResultUtils.success("删除商机成功");
    }

    @PostMapping("/del_batch_salesopport")
    public ResultVo delBatchSalesopport(@RequestBody Integer[] salesopport){
        this.salesopportService.delBatchSalesopport(salesopport);
        return ResultUtils.success("删除商机成功");
    }

    /**
     *功能描述 通过客户查询商机
     * @author 廖湘明
     * @date 2020/10/11
     * @param
     * @return
     */
    @PostMapping("/query_salesopport_by_customer")
    public ResultVo querySalesOpportByCustomer(@RequestBody Customer customer){
        return ResultUtils.success("通过客户查询商机",this.salesopportService.querySalesOpportByCustomer(customer));
    }
    /*@PostMapping("/query_salesopport_funnle")
    public Map querySalesOpportFunnle(@RequestBody List<User> users){
        System.out.println(users.toString());
        return jrcSalesopportService.querySalesOpportFunnle(users);
    }

    @GetMapping("/query_salesopport_by_cusid")
    public List<Salesopport> querySalesOpportByCusId(Integer cusId){
        return jrcSalesopportService.querySalesOpportByCusid(cusId);
    }

    @GetMapping("/query_salesopport_by_forecast")
    public Map querySalesOpportByForecast(@DateTimeFormat(pattern = "yyyy-MM-dd")Date timeStart, @DateTimeFormat(pattern = "yyyy-MM-dd")Date timeEnd, String possibity, Integer status, Integer curpage, Integer pagesize){
        return jrcSalesopportService.querySalesOpportByForecast(timeStart,timeEnd,possibity,status,curpage,pagesize);
    }

    @GetMapping("/query_finalll_sales_opport_by_forecast")
    public Map queryFinalllSalesOpportByForecast(@DateTimeFormat(pattern = "yyyy-MM-dd")Date timeStart,@DateTimeFormat(pattern = "yyyy-MM-dd")Date timeEnd,String possibity,Integer uId,Integer curpage,Integer pagesize){
        return jrcSalesopportService.queryFinalllSalesOpportByForecast(timeStart,timeEnd,uId,possibity,curpage,pagesize);
    }
    @GetMapping("/query_salesEarch1")
    public List<CountPie> querySalesEarch1(Integer op){
        return jrcSalesopportService.querySalesEarch1(op);
    }
    @GetMapping("/query_salesEarch2")
    public CountBar querySalesEarch2(Integer op){
        return jrcSalesopportService.querySalesEarch2(op);
    }

    @GetMapping("/query_salesEarch3")
    public Map   querySalesEarch3(Integer op){
        return jrcSalesopportService.querySalesEarch3(op);
    }
    @PostMapping("/query_salesFunnel1")
    public  List<Map> querySalesFunnel1(@RequestBody JrcSalesFunnelUO s){
        return jrcSalesopportService.querySalesFunnel1(s);
    }*/
}
