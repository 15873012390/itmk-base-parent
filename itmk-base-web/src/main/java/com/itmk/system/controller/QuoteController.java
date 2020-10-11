package com.itmk.system.controller;

import com.itmk.result.ResultUtils;
import com.itmk.result.ResultVo;
import com.itmk.system.entity.Quote;
import com.itmk.system.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *功能描述 报价单控制层
 * @author 廖湘明
 * @date 2020/10/10
 */
@RestController
@RequestMapping(value = "/api/Quote")
public class QuoteController {
    @Autowired
    private QuoteService quoteService;

    /**
     *功能描述 新建/编辑报价单
     * @author 廖湘明
     * @date 2020/10/11
     * @param
     * @return
     */
    @PostMapping("/add_quote")
    public ResultVo addQuote(@RequestBody Quote quote){
        this.quoteService.addQuote(quote);
        return ResultUtils.success("新建/编辑报价单");
    }
    /**
     *功能描述 查询所有报价单
     * @author 廖湘明
     * @date 2020/10/11
     * @param
     * @return
     */
    @GetMapping("/flash_quote_bysoid")
    public ResultVo flashQuoteBysoid(Integer soId){
        return ResultUtils.success("查询所有报价单",this.quoteService.flashQuoteBysoid(soId));
    }
    /**
     *功能描述 通过id查询报价
     * @author 廖湘明
     * @date 2020/10/11
     * @param
     * @return
     */
    @GetMapping("/query_by_quoId")
    public ResultVo queryByQuoId(Integer quoId){
        return ResultUtils.success("通过id查询报价",this.quoteService.queryByQuoId(quoId));
    }
    /**
     *功能描述 通过id删除报价单以及报价明细
     * @author 廖湘明
     * @date 2020/10/11
     * @param
     * @return
     */
    @DeleteMapping("/delete_by_quoId")
    public ResultVo deleteByQuoId(Integer quoId){
        this.quoteService.deleteByQuoId(quoId);
        return ResultUtils.success("通过id删除报价单以及报价明细");
    }
}
