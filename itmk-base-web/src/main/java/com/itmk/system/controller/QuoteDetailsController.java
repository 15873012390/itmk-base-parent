package com.itmk.system.controller;

import com.itmk.result.ResultUtils;
import com.itmk.result.ResultVo;
import com.itmk.system.entity.Quotedetails;
import com.itmk.system.service.QuoteDetailsService;
import com.itmk.system.vo.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *功能描述 报价单详情控制层
 * @author 廖湘明
 * @date 2020/10/10
 */
@RestController
@RequestMapping(value = "/api/QuoteDetails")
public class QuoteDetailsController {
    @Autowired
    private QuoteDetailsService quoteDetailsService;
    /**
     *功能描述 通过报价单id查询报价单详情
     * @author 廖湘明
     * @date 2020/10/11
     * @param
     * @return
     */
    @GetMapping("/query_quote_details_by_quoId")
    public ResultVo queryQuoteDetailsByQuoId(Integer quoId){
        return ResultUtils.success("通过报价单id查询报价单详情",this.quoteDetailsService.queryQuoteDetailsByQuoId(quoId));
    }

    /**
     *功能描述 保存明细数据
     * @author 廖湘明
     * @date 2020/10/11
     * @param
     * @return
     */
    @PostMapping("/save_quote_details")
    public ResultVo saveQuoteDetails(@RequestBody List<Quotedetails> list){
        this.quoteDetailsService.saveQuoteDetails(list);
        return ResultUtils.success("保存明细数据");
    }
}
