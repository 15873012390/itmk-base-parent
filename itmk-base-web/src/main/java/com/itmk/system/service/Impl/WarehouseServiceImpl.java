package com.itmk.system.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itmk.system.entity.Product;
import com.itmk.system.entity.Warehouse;
import com.itmk.system.entity.jpa.JpaWarehouseDao;
import com.itmk.system.mapper.WarehouseDao;
import com.itmk.system.service.WarehouseService;
import com.itmk.system.vo.Pager;
import com.itmk.system.vo.WarehouseAdvancedSearch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@Slf4j
public class WarehouseServiceImpl extends ServiceImpl<WarehouseDao,Warehouse> implements WarehouseService{

    @Autowired
    private WarehouseDao warehouseDao;
    @Autowired
    private JpaWarehouseDao jpaWarehouseDao;

    @Override
    public List<Warehouse> queryAllWarehouse() {
        return this.warehouseDao.queryAllWarehouse();
    }

    @Override
    public Pager<Warehouse> queryAllWarehouseByPage(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        PageInfo<Warehouse> pageInfo=new PageInfo<>(this.warehouseDao.queryAllWarehouse());
        return new Pager<Warehouse>(pageInfo.getTotal(),pageInfo.getList());
    }

    public Pager<Warehouse> querySelectOrInputWarehouse(String value,String input,String select,Integer curpage,Integer pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Warehouse> clist = this.warehouseDao.querySelectOrInput(value,"%"+input.trim()+"%",select);
        PageInfo<Warehouse> pager = new PageInfo<>(clist);
        return new Pager<Warehouse>(pager.getTotal(),pager.getList());
    }
    /**
     * 高级查询
     * @param was
     * @return
     */
    public Pager<Warehouse> queryByAdvanced(WarehouseAdvancedSearch was){
        PageHelper.startPage(was.getCurrentPage(),was.getPageSize());
        was.setWarehouseName("%"+was.getWarehouseName()+"%");
        List<Warehouse> list = this.warehouseDao.queryByAdvanced(was);
        PageInfo<Warehouse> pager = new PageInfo<>(list);
        return new Pager<Warehouse>(pager.getTotal(),pager.getList());
    }

    /**
     * 保存或编辑仓库
     * @param warehouse
     */
    public void addOreditWarehouse(Warehouse warehouse){
        this.jpaWarehouseDao.save(warehouse);
    }

    /**
     * 通过仓库ID查询仓库
     * @param warehouseId
     * @return
     */
    public Warehouse queryByWarehouseId(Integer warehouseId){
        return this.warehouseDao.queryByWarehouseId(warehouseId);
    }


    /**
     * 根据仓库ID删除仓库
     * @param warehouseId
     * @return
     */
    public String deleteByWarehouseId(Integer warehouseId){
        Warehouse warehouse=this.warehouseDao.queryByWarehouseId(warehouseId);
        if(warehouse==null){
            return "1";
        }
        /*if(warehouse.getPurchaseplan()!=null&&warehouse.getPurchaseplan().size()>0){
            return "采购计划有该仓库不能删除！";
        }
        if(warehouse.getInstock()!=null&&warehouse.getInstock().size()>0){
            return "入库单有该仓库不能删除！";
        }
        if(warehouse.getOutstock()!=null&&warehouse.getOutstock().size()>0){
            return "有要出库的产品不能删除";
        }*/
        if(warehouse.getStock()!=null&&warehouse.getStock().size()>0){
            return "库存有该仓库不能删除";
        }
        /*if(warehouse.getReturnedgoods()!=null&&warehouse.getReturnedgoods().size()>0){
            return "产品退货有该仓库不能删除";
        }*/
        //***
        this.warehouseDao.deleteById(warehouseId);
        return "1";
    }



    /**
     * 批量删除仓库
     * @param ids
     * @return
     */
    public String deleteByWarehouseIds(Integer[] ids){
        for(Integer id:ids){
            Warehouse warehouse = this.warehouseDao.queryByWarehouseId(id);
            /*if(warehouse.getPurchaseplan()!=null&&warehouse.getPurchaseplan().size()>0){
                return "采购计划有该仓库不能删除！";
            }
            if(warehouse.getInstock()!=null&&warehouse.getInstock().size()>0){
                return "入库单有该仓库不能删除！";
            }
            if(warehouse.getOutstock()!=null&&warehouse.getOutstock().size()>0){
                return "有要出库的产品不能删除";
            }*/
            if(warehouse.getStock()!=null&&warehouse.getStock().size()>0){
                return "库存有该仓库不能删除";
            }
            /*if(warehouse.getReturnedgoods()!=null&&warehouse.getReturnedgoods().size()>0){
                return "产品退货有该仓库不能删除";
            }*/
            this.warehouseDao.deleteById(id);
        }
        return "1";

    }
}
