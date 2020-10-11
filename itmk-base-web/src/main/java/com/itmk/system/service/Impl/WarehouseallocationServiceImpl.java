package com.itmk.system.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itmk.system.entity.*;
import com.itmk.system.entity.jpa.JpaSysUser;
import com.itmk.system.mapper.*;
import com.itmk.system.mapper.jpa.JpaStockDao;
import com.itmk.system.service.WarehouseallocationService;
import com.itmk.system.vo.Pager;
import com.itmk.system.vo.WarehouseallocationAdvancedSearchVo;
import com.itmk.system.vo.WarehouseallocationdetailVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uuid.UUIDUtil;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 仓库调拨业务接口实现类
 * @author 廖湘明
 * @data 2020/9/21 15:14
 * @return
 */
@Slf4j
@Service
@Transactional
public class WarehouseallocationServiceImpl implements WarehouseallocationService {
    @Autowired
    private WarehouseallocationDao warehouseallocationDao;
    @Autowired
    private InstockDao instockDao;
    @Autowired
    private OutstockDao outstockDao;
    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private StockDao stockDao;
    @Autowired
    private JpaStockDao jpaStockDao;
    @Override
    public Pager<Warehouseallocation> selectWaByPage(Integer currentPage,Integer pageSize) {
        List<Warehouseallocation> list1 = this.warehouseallocationDao.selectWaByPage();
        List list2 = new ArrayList();
        for (int i = 0; i < pageSize; i++) {
            int index = (currentPage - 1) * pageSize + i;
            if (index < list1.size()) {
                if (list1.get(index) != null) {
                    list2.add(list1.get(index));
                }
            }
        }
        return new Pager<Warehouseallocation>(list1.size(), list2);
    }

    @Override
    public Pager<Warehouseallocation> queryBySelectAndInput(String value, String input, String select, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Warehouseallocation> list= this.warehouseallocationDao.queryBySelectAndInput(value, "%"+input+"%".trim(), select);
        PageInfo<Warehouseallocation> pageInfo=new PageInfo<>(list);
        return new Pager<Warehouseallocation>(pageInfo.getTotal(),pageInfo.getList());
    }

    @Override
    public Pager<Warehouseallocation> queryByAdvanced(WarehouseallocationAdvancedSearchVo waad) {
        if (waad.getWaDate() != null && waad.getWaDate().length != 0) {
            waad.setS1(waad.getWaDate()[0]);
            waad.setS2(waad.getWaDate()[1]);
        }
        PageHelper.startPage(waad.getCurrentPage(),waad.getPageSize());
        List<Warehouseallocation> list= this.warehouseallocationDao.queryByAdvanced(waad);
        PageInfo<Warehouseallocation> pageInfo=new PageInfo<>(list);
        return new Pager<Warehouseallocation>(pageInfo.getTotal(),pageInfo.getList());
    }

    @Override
    public void addAndEditWahouseallocation(Warehouseallocation warehouseallocation) {
        if (warehouseallocation.getWaId() == 0) {//判断是否是新增
            warehouseallocation.setWaStatus("未执行");//设置状态
           this.warehouseallocationDao.insertWa(warehouseallocation);
           /*Instock instock=new Instock();
           instock.setTitle(warehouseallocation.getTitle());
           instock.setWarehouse(warehouseallocation.getInwarehouse());
           instock.setFillTime(warehouseallocation.getWaDate());
           instock.setStatus(warehouseallocation.getWaStatus()=="未执行"?"未入库":"入库");
           instock.setFiller(warehouseallocation.get);
           this.instockDao.insertInstock(instock);*/

        } else {
            //修改调拨表时，如果有入库和出库记录的仓库也要一起改
            this.warehouseallocationDao.updateWa(warehouseallocation);
            if (warehouseallocation.getInstock().getInsId()!=0) {//判断有没有入库记录，有的话就修改
                Instock instock = this.instockDao.queryByInsId(warehouseallocation.getInstock().getInsId());//入库记录
                instock.setWarehouse(warehouseallocation.getInwarehouse());//设置入库仓库
                this.instockDao.updateInstock(instock);
            }
            if (warehouseallocation.getOutstock().getOutId() != 0) {//判断有没有出库记录，有的话就修改
                Outstock outstock = this.outstockDao.queryOutstockByOutId(warehouseallocation.getOutstock().getOutId());//出库记录
                outstock.setWarehouse(warehouseallocation.getOutwarehouse());//设置出库仓库
                this.outstockDao.updateOutStock(outstock);
            }
        }
    }

    @Override
    public Warehouseallocation queryWaByWaId(Integer waId) {
        Warehouseallocation wa = this.warehouseallocationDao.queryWaByWaId(waId);
        if (wa != null) {
            if (wa.getInUser() == null) {
                wa.setInUser(new JpaSysUser());
            }
            if (wa.getOutUser() == null) {
                wa.setOutUser(new JpaSysUser());
            }
            if (wa.getInstock() == null) {
                wa.setInstock(new Instock());
            }
            if (wa.getOutstock() == null) {
                wa.setOutstock(new Outstock());
            }
            if (wa.getInwarehouse() == null) {
                wa.setInwarehouse(new Warehouse());
            }
            if (wa.getOutwarehouse() == null) {
                wa.setOutwarehouse(new Warehouse());
            }

            if (wa.getWarehouseallocationdetails() != null && wa.getWarehouseallocationdetails().get(0).getWadId() != 0) {
                System.out.println(107);
                for (Warehouseallocationdetail wad : wa.getWarehouseallocationdetails()) {
                    if (wad.getWarehouseallocation().getInUser() == null) {
                        wad.getWarehouseallocation().setInUser(new JpaSysUser());
                    }
                    if (wad.getWarehouseallocation().getOutUser() == null) {
                        wad.getWarehouseallocation().setOutUser(new JpaSysUser());
                    }
                    if (wad.getWarehouseallocation().getInstock() == null) {
                        wad.getWarehouseallocation().setInstock(new Instock());
                    }
                    if (wad.getWarehouseallocation().getOutstock() == null) {
                        wad.getWarehouseallocation().setOutstock(new Outstock());
                    }
                    if (wad.getWarehouseallocation().getInwarehouse() == null) {
                        wad.getWarehouseallocation().setInwarehouse(new Warehouse());
                    }
                    if (wad.getWarehouseallocation().getOutwarehouse() == null) {
                        wad.getWarehouseallocation().setOutwarehouse(new Warehouse());
                    }
                    if (wad.getProductspecification() == null) {
                        wad.setProductspecification(new Productspecification());
                    }
                }
            } else {
                System.out.println(132);
                wa.setWarehouseallocationdetails(null);
            }
        }

        return wa;
    }
    public void deleteWaByWaId(Integer waId) {
        Warehouseallocation wa = this.warehouseallocationDao.queryWaByWaId(waId);
        this.warehouseallocationDao.deleteWaByWaId(waId);
        if(wa.getInstock()!=null){
            instockDao.deleteInstockById(wa.getInstock().getInsId());
            instockDao.deleteInstockDetailById(wa.getInstock().getInsId());
        }
        if(wa.getOutstock()!=null) {
            outstockDao.deleteOutstockByOutId(wa.getOutstock().getOutId());
            outstockDao.deleteOutstockDetailByOutId(wa.getOutstock().getOutId());
        }
    }

    @Override
    /**
     * 仓库调拨单增加产品详情
     *
     * @param warehouseallocationdetailVo
     */
    public void addAndEditWad(WarehouseallocationdetailVo warehouseallocationdetailVo) {
        boolean flag = true;
        boolean flag2 = true;
        Warehouseallocation wa = null;
        Instock instock1 = null;
        Outstock outstock1 = null;
        Instock instock = new Instock();
        Outstock outstock = new Outstock();
        Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        //获取String类型的时间
        String createdate = sdf.format(date);
        for (Warehouseallocationdetail wad : warehouseallocationdetailVo.getList()) {

            Warehouseallocationdetail wads = new Warehouseallocationdetail();
            //添加调拨详情单
            wa = this.warehouseallocationDao.queryWaByWaId(wad.getWarehouseallocation().getWaId());
            if (wa != null) {
                wads.setProductspecification(wad.getProductspecification());
                wads.setWadQuantity(wad.getWadQuantity());
                wads.setWarehouseallocation(wa);
                if (wad.getWadId() == 0) {//如果为0表示没有该条详情记录，则新增调拨详情记录
                    this.warehouseallocationDao.insertWad(wads);
                } else {
                    wads.setWadId(wad.getWadId());//调拨详情id
                    this.warehouseallocationDao.updateWad(wads);
                }
                //如果入库单没有数据就添加入库单
                if (wa.getInstock() == null) {
                    if (flag) {
                        instock.setTitle(createdate + "调拨入库单");
                        instock.setFiller(warehouseallocationdetailVo.getuName());
                        instock.setFillTime(new Timestamp(System.currentTimeMillis()));
                        instock.setStatus("未入库");
                        instock.setWarehouse(wads.getWarehouseallocation().getInwarehouse());
                        instock.setWarehouseallocation(wa);
                        instockDao.insertInstock(instock);
                        wa.setInstock(instock);
                        this.warehouseallocationDao.updateWa(wa);
                        flag = false;
                    }
                    Instockdetail instockdetail = new Instockdetail();
                    instockdetail.setInstock(instock);
                    instockdetail.setStatus("未入库");
                    instockdetail.setInsdQuantity(wad.getWadQuantity());
                    instockdetail.setProductspecification(wad.getProductspecification());
                    instockDao.insertInstockDetail(instockdetail);
                } else {
                    //否则在原有的基础上添加详情
                    instock1 = instockDao.queryByInsId(wa.getInstock().getInsId());
                    Instockdetail instockdetail = new Instockdetail();
                    instockdetail.setInstock(instock1);
                    instockdetail.setStatus("未入库");
                    instockdetail.setInsdQuantity(wad.getWadQuantity());
                    instockdetail.setProductspecification(wad.getProductspecification());
                    Instockdetail insd = instockDao.queryInsdByInsIdAndSpeId(instock1.getInsId(), wad.getProductspecification().getSpeId());
                    if (insd != null) {
                        instockDao.updateInstockDetail(instockdetail);
                    } else {
                        instockDao.insertInstockDetail(instockdetail);
                    }


                }
                //如果入库单没有数据就添加入库单
                if (wa.getOutstock() == null) {
                    if (flag2) {
                        outstock.setTitle(createdate + "调拨出库单");
                        outstock.setOutNumber(UUIDUtil.getUniqueIdByUUId());
                        outstock.setFillTime(new Timestamp(System.currentTimeMillis()));
                        outstock.setStatus("未出库");
                        outstock.setWarehouse(wads.getWarehouseallocation().getInwarehouse());
                        outstock.setWarehouseallocation(wa);
                        outstockDao.insertOutstock(outstock);
                        wa.setOutstock(outstock);
                        this.warehouseallocationDao.updateWa(wa);
                        flag2 = false;
                    }
                    Outstockdetails outstockdetails = new Outstockdetails();
                    outstockdetails.setOutstock(outstock);
                    outstockdetails.setStatus("未出库");
                    outstockdetails.setOsdNumber(wad.getWadQuantity());
                    outstockdetails.setProductspecification(wad.getProductspecification());
                    outstockDao.insertOutStockDetails(outstockdetails);
                } else {
                    //否则在原有的基础上添加详情
                    outstock1 = outstockDao.queryOutstockByOutId(wa.getOutstock().getOutId());
                    Outstockdetails outstockdetails = new Outstockdetails();
                    outstockdetails.setOutstock(outstock1);
                    outstockdetails.setStatus("未出库");
                    outstockdetails.setOsdNumber(wad.getWadQuantity());
                    outstockdetails.setProductspecification(wad.getProductspecification());
                    Outstockdetails osd = outstockDao.queryOsdByOutIdAndSpeId(outstock1.getOutId(), wad.getProductspecification().getSpeId());
                    if (osd != null) {
                        outstockDao.updateOutDeatails(outstockdetails);
                    } else {
                        outstockDao.insertOutStockDetails(outstockdetails);
                    }
                }
                for (Integer id : warehouseallocationdetailVo.getDelList()) {
                    if (instock1 != null) {
                        instockDao.deleteInstockDetailBySpeIdAndInsId(id, instock1.getInsId());
                    }
                    this.warehouseallocationDao.deleteWaByWaIdAndSpeId(wa.getWaId(), id);
                    if (outstock1 != null) {
                        outstockDao.deleteOutstockDetailByOutIdAndSpeId(outstock1.getOutId(), id);
                    }

                }

            }

        }
    }

    /**
     * 去入库出库确认
     *
     * @param waId
     * @param type
     * @param uId
     */
    public void toConfirm(Integer waId, Integer type, Integer uId) {
        Warehouseallocation wa = this.warehouseallocationDao.queryWaByWaId(waId);
        JpaSysUser user = this.userMapper.findById((long)uId);

        if (type == 1) {
            wa.setInUser(user);
        }
        if (type == 2) {
            wa.setOutUser(user);
        }
        if (type == 3) {
            user.setId(0);
            wa.setInUser(user);
        }
        if (type == 4) {
            user.setId(0);
            wa.setOutUser(user);
        }
        this.warehouseallocationDao.updateWa(wa);
    }

    @Override
    public String toOutAndInStock(Integer waId, String uName) {
        Warehouseallocation wa = this.warehouseallocationDao.queryWaByWaId(waId);
        if (wa != null) {
            //出库不为空则相应往仓库加数据
            if (wa.getOutstock() != null) {
                Outstock outstock = outstockDao.queryOutstockByOutId(wa.getOutstock().getOutId());
                boolean flag = false;
                StringBuffer sb = new StringBuffer();
                sb.append(wa.getOutwarehouse().getWarehouseName() + ":" + "<br/>" + "<br/>");
                //用于保存符合要求的产品
                List<Stock> stocks = new ArrayList<>();
                Stock stock = null;
                for (Outstockdetails outstockdetails : wa.getOutstock().getOutstockdetail()) {
                    //所在的仓库不为空则修改原有的数量，否则新增。
                    stock = this.stockDao.queryStockByWarehouseAndSpeId(outstockdetails.getProductspecification().getSpeId(), wa.getOutwarehouse().getWarehouseId());
                    System.out.println("429"+stock);
                    if (stock != null && stock.getStockId()!=0) {
                        if (stock.getStockQuantity() >= outstockdetails.getOsdNumber()) {
                            stock.setStockQuantity(stock.getStockQuantity() - outstockdetails.getOsdNumber());
                            stock.setProductspecification(outstockdetails.getProductspecification());
                            stock.setWarehouse(wa.getOutwarehouse());
                            stocks.add(stock);
                        } else {
                            flag = true;
                            sb.append(outstockdetails.getProductspecification().getProName() + "余量不足，无法进行调拨，请保证库存充足！" + "<br/>");
                        }
                    }else{
                        flag = true;
                        sb.append(outstockdetails.getProductspecification().getProName() + "余量不足，无法进行调拨，请保证库存充足！" + "<br/>");
                    }
                }
                if (flag) {
                    return sb.toString();
                } else {
                    outstock.setPassPerson(uName);
                    outstock.setPassTime(new Timestamp(System.currentTimeMillis()));
                    outstock.setStatus("已出库");
                    outstockDao.updateOutStock(outstock);
                    for (Stock s : stocks) {
                        this.stockDao.updatestockQuantity(s.getStockQuantity(), s.getProductspecification().getSpeId(), s.getWarehouse().getWarehouseId());
                    }
                    //入库不为空则相应往仓库加数据
                    if (wa.getInstock() != null) {
                        Instock instock = instockDao.queryByInsId(wa.getInstock().getInsId());
                        instock.setKeeper(uName);
                        instock.setExecutionTime(new Timestamp(System.currentTimeMillis()));
                        instock.setStatus("已入库");
                        instockDao.updateInstock(instock);
                        for (Instockdetail instockdetail : wa.getInstock().getInstockdetail()) {
                            Stock stock2 = this.stockDao.queryStockByWarehouseAndSpeId(instockdetail.getProductspecification().getSpeId(), wa.getInwarehouse().getWarehouseId());
                            if (stock2 != null && stock2.getStockId()!=0) {
                                stock2.setStockQuantity(stock2.getStockQuantity() + instockdetail.getInsdQuantity());
                                this.stockDao.updatestockQuantity(stock2.getStockQuantity(), instockdetail.getProductspecification().getSpeId(), wa.getInwarehouse().getWarehouseId());
                            } else {
                                Stock stock1 = new Stock();
                                stock1.setProductspecification(instockdetail.getProductspecification());
                                stock1.setWarehouse(instock.getWarehouse());
                                stock1.setStockQuantity(instockdetail.getInsdQuantity());
                                this.jpaStockDao.save(stock1);
                            }
                        }
                    }
                    wa.setWaStatus("已执行");
                    this.warehouseallocationDao.updateWa(wa);
                }
            }

        }

        return "1";
    }

    @Override
    public String removeWaStatus(Integer waId) {
        Warehouseallocation wa = this.warehouseallocationDao.queryWaByWaId(waId);
        boolean flag = false;
        StringBuffer sb = new StringBuffer();
        sb.append(wa.getInwarehouse().getWarehouseName() + ":" + "<br/>" + "<br/>");
        List<Stock> stocks = new ArrayList<>();
        Stock stock = null;
        for (Instockdetail i : wa.getInstock().getInstockdetail()) {
            stock = this.stockDao.queryStockByWarehouseAndSpeId(i.getProductspecification().getSpeId(), wa.getInwarehouse().getWarehouseId());
            System.out.println("498"+stock);
            if (stock != null) {
                if (stock.getStockQuantity() >= i.getInsdQuantity()) {
                    stock.setStockQuantity(stock.getStockQuantity() - i.getInsdQuantity());
                    stock.setWarehouse(wa.getInwarehouse());
                    stock.setProductspecification(i.getProductspecification());
                    stocks.add(stock);
                } else {
                    flag = true;
                    sb.append(i.getProductspecification().getProName() + "余量不足，无法进行调拨，请保证库存充足！" + "<br/>");
                }
            }else{
                flag = true;
                sb.append(i.getProductspecification().getProName() + "余量不足，无法进行调拨，请保证库存充足！" + "<br/>");
            }
        }
        boolean flag3 = false;
        boolean flag4 = false;
        StringBuffer sb2 = new StringBuffer();
        if (flag) {
            return sb.toString();
        } else {
            JpaSysUser user = new JpaSysUser();
            user.setId(0);
            wa.setWaStatus("未执行");
            wa.setInUser(user);
            wa.setOutUser(user);
            this.warehouseallocationDao.updateWa(wa);
            Instock instock = instockDao.queryByInsId(wa.getInstock().getInsId());
            instock.setStatus("未入库");
            instock.setKeeper(null);
            instock.setExecutionTime(null);
            instockDao.updateInstock(instock);
            for (Stock s : stocks) {
                this.stockDao.updatestockQuantity(s.getStockQuantity(), s.getProductspecification().getSpeId(), s.getWarehouse().getWarehouseId());
            }
            Outstock outstock = outstockDao.queryOutstockByOutId(wa.getOutstock().getOutId());
            outstock.setPassPerson(null);
            outstock.setPassTime(null);
            outstock.setStatus("未出库");
            outstockDao.updateOutStock(outstock);
            for (Outstockdetails outstockdetails : wa.getOutstock().getOutstockdetail()) {
                Stock stock2 = this.stockDao.queryStockByWarehouseAndSpeId(outstockdetails.getProductspecification().getSpeId(), wa.getOutwarehouse().getWarehouseId());
                if (stock2 != null && stock2.getStockId()!=0) {
                    stock2.setStockQuantity(stock2.getStockQuantity() + outstockdetails.getOsdNumber());
                    this.stockDao.updatestockQuantity(stock2.getStockQuantity(), outstockdetails.getProductspecification().getSpeId(), wa.getOutwarehouse().getWarehouseId());
                } else {
                    Stock stock1 = new Stock();
                    stock1.setProductspecification(outstockdetails.getProductspecification());
                    stock1.setWarehouse(wa.getOutwarehouse());
                    stock1.setStockQuantity(outstockdetails.getOsdNumber());
                    this.jpaStockDao.save(stock1);
                }
            }
            return "1";
        }
    }
}
