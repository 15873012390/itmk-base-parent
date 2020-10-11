package com.itmk.system.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itmk.system.entity.Product;
import com.itmk.system.entity.Productclassification;
import com.itmk.system.entity.Productspecification;
import com.itmk.system.mapper.ProductclassificationDao;
import com.itmk.system.mapper.ProductspecificationDao;
import com.itmk.system.mapper.StockDao;
import com.itmk.system.mapper.jpa.LxmJpaProductDao;
import com.itmk.system.vo.CountPieVo;
import com.itmk.system.vo.ProductAdvancedSearch;
import com.itmk.system.mapper.ProductDao;
import com.itmk.system.service.ProductService;
import com.itmk.system.vo.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl extends ServiceImpl<ProductDao,Product> implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private LxmJpaProductDao productJDao;
    @Autowired
    private ProductspecificationDao productspecificationDao;
    @Autowired
    private ProductclassificationDao productclassificationDao;
    @Autowired
    private StockDao stockDao;
    @Override
    public Pager<Product> queryAllProduct(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Product> list= this.productDao.queryAllProduct();
        PageInfo<Product> pageInfo=new PageInfo<>(list);
        return new Pager<Product>(pageInfo.getTotal(),pageInfo.getList());
    }

    @Override
    public Pager<Product> seachProductByShuJu(String value, String input, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Product> list= this.productDao.seachProductByShuJu(value,"%"+input.trim()+"%");
        PageInfo<Product> pageInfo=new PageInfo<>(list);
        return new Pager<Product>(pageInfo.getTotal(),pageInfo.getList());
    }

    @Override
    public Pager<Product> productAdvancedSearch(ProductAdvancedSearch productAdvancedSearch) {
        PageHelper.startPage(productAdvancedSearch.getCurrentPage(),productAdvancedSearch.getPageSize());
        List<Product> list= this.productDao.productAdvancedSearch(productAdvancedSearch);
        PageInfo<Product> pageInfo=new PageInfo<>(list);
        return new Pager<Product>(pageInfo.getTotal(),pageInfo.getList());
    }

    @Override
    public void deleteProudctById(Integer pid) {
        Product p=this.productDao.findProductById(pid);
        p.setProDelState(2);//设置删除状态为2
        this.productJDao.save(p);//jpa的保存/修改方法
    }

    @Override
    public Product findProductById(Integer proid) {
        return this.productDao.findProductById(proid);
    }

    @Override
    public Integer addAndUpdateProduct(Product product){
        System.out.println("76"+product.getProId());
        product.setProDelState(1);
        product.setProDate(new Timestamp(System.currentTimeMillis()));
        //保存
        if(product.getProId()==0){
            this.productDao.insertProduct(product);
            List<Productspecification> list=this.productspecificationDao.queryProductspecificationByProId(product.getProId());
            System.out.println("83"+list);
            if(list.size()==0){
                System.out.println(86);
                Productspecification productspecification=new Productspecification();
                productspecification.setProduct(product);
                productspecification.setProName(product.getProName());
                productspecification.setSpeSpecification("基准");
                productspecification.setSpeUnit("个");
                productspecification.setSpeUnitConversion(1);
                this.productspecificationDao.insertSpeProduct(productspecification);
                return product.getProId();
            }else{
                return 0;
            }
        }else{
            this.productDao.updateProduct(product);
        }
        return 0;


    }

    @Override
    public List<CountPieVo> queryByStock() {
        return this.stockDao.queryByStock();
    }

    @Override
    public Product findBySpeid(Integer speid) {
        return this.productDao.findBySpeid(speid);
    }

    @Override
    public List<Productclassification> findAllCla(){
        return this.productclassificationDao.findAll();
    }
}
