package com.itmk.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itmk.system.entity.Product;
import com.itmk.system.entity.Productclassification;
import com.itmk.system.vo.CountPieVo;
import com.itmk.system.vo.ProductAdvancedSearch;
import com.itmk.system.vo.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/*
* 产品业务接口
* */
public interface ProductService extends IService<Product> {
    //查询所有产品
    public Pager<Product> queryAllProduct(Integer currentPage, Integer pageSize);

    //通过下拉框数据搜索产品
    public Pager<Product> seachProductByShuJu(String value, String input, Integer currentPage, Integer pageSize);

    //高级查询产品
    public Pager<Product> productAdvancedSearch(ProductAdvancedSearch productAdvancedSearch);

    //删除产品(只修改状态，逻辑删除）
    public void deleteProudctById(Integer pid);

    //通过id查找产品
    public Product findProductById(Integer proid);

    //新增/编辑产品
    public Integer addAndUpdateProduct(Product product);

    //产品详情页上 统计每个仓库还有多少库存
    public List<CountPieVo> queryByStock();

    //通过规格id查询产品
    public Product findBySpeid(Integer speid);

    //选择产品页面
    public List<Productclassification> findAllCla();
}
