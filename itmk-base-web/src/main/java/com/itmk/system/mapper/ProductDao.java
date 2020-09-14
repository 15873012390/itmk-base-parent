package com.itmk.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itmk.system.entity.Product;
import com.itmk.system.vo.ProductAdvancedSearch;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
* 产品mapper接口
* */
public interface ProductDao extends BaseMapper<Product> {
    //查询全部与产品
    public List<Product> queryAllProduct();
    //通过下拉框数据搜索产品
    public List<Product> seachProductByShuJu(@Param("value") String value, @Param("input") String input);
    //高级查询产品
    public List<Product> productAdvancedSearch(ProductAdvancedSearch productAdvancedSearch);
    //通过id查找产品
    public Product findProductById(@Param("proid") Integer proid);
    //插入产品
    public void insertProduct(Product product);
    //修改产品
    public void updateProduct(Product product);
}