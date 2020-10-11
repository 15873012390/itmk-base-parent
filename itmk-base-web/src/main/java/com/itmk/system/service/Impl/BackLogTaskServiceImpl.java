package com.itmk.system.service.Impl;

import com.itmk.system.entity.Backlogtask;
import com.itmk.system.entity.Backlogtaskdetails;
import com.itmk.system.entity.jpa.JpaSysUser;
import com.itmk.system.mapper.BackLogTaskDao;
import com.itmk.system.mapper.BackLogTaskDetailsDao;
import com.itmk.system.mapper.jpa.JpaBackLogTaskDao;
import com.itmk.system.mapper.jpa.JpaBackLogTaskDetailsDao;
import com.itmk.system.service.BackLogTaskService;
import com.itmk.system.service.CustomerAndUserService;
import com.itmk.system.vo.BackLogTaskVo;
import com.itmk.system.vo.Pager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.transform.Result;
import java.sql.Timestamp;
import java.util.*;

/**
 * @author 廖湘明
 * @data 2020/10/10 18:55
 * @return
 */
@Slf4j
@Service
@Transactional
public class BackLogTaskServiceImpl implements BackLogTaskService {
    @Autowired
    private BackLogTaskDao backLogTaskDao;
    @Autowired
    private BackLogTaskDetailsDao backLogTaskDetailsDao;
    @Autowired
    private JpaBackLogTaskDetailsDao jpaBackLogTaskDetailsDao;
    @Autowired
    private CustomerAndUserService customerAndUserService;
    @Autowired
    private JpaBackLogTaskDao jpaBackLogTaskDao;
    @Override
    public Pager queryAllBackLogTaskByCusId(Integer cusId, Integer currentPage, Integer pageSize) {
        List<Backlogtask> list=this.backLogTaskDao.queryBackLogTaskByCusId(cusId);
        List list1=new ArrayList();
        for(int i=0;i<pageSize;i++){
            int index=(currentPage-1)*pageSize+i;
            if(index<list.size()){
                if(list.get(index)!=null){
                    list1.add(list.get(index));
                }
            }
        }
        return new Pager<Backlogtask>(list.size(),list1);
    }

    @Override
    public void AddBackLogTaskAndDetail(BackLogTaskVo backLogTaskVo) {
        Backlogtask b1=new Backlogtask();
        b1=this.backLogTaskDao.queryBackLogTaskByBltId(backLogTaskVo.getBltId());

        Backlogtask b2=new Backlogtask();
        b2.setBltDescription(backLogTaskVo.getBltDescription());
        b2.setFinishDate(backLogTaskVo.getFinishDate());
        b2.setFinishTime(backLogTaskVo.getFinishTime());
        b2.setPrecedence(backLogTaskVo.getPrecedence());
        b2.setConName(backLogTaskVo.getConName());
        b2.setStatus(backLogTaskVo.getStatus());
        b2.setDelStatus(1);
        //客户
        if(backLogTaskVo.getCustomer()!=null){
            b2.setCustomer(backLogTaskVo.getCustomer());
        }
        //判断详情id为不为空
        if(b1!=null){
            b2.setBltId(backLogTaskVo.getBltId());
            b2.setUser(b1.getUser());
            b2.setCreationTime(b1.getCreationTime());
            List<Backlogtaskdetails> bd2=this.backLogTaskDetailsDao.queryBackLogTaskUserBybltId(b1.getBltId());
            System.out.println(bd2.size());
            for(int i=0;i<bd2.size();i++){
                this.jpaBackLogTaskDetailsDao.delete(bd2.get(i));
            }

        }else{
            b2.setCreationTime(new Timestamp(new Date().getTime()));
            //前台获取员工
            System.out.println("---------------");
            System.out.println(backLogTaskVo.getUid());
            System.out.println("---------------");
            JpaSysUser user = this.customerAndUserService.queryByUid(backLogTaskVo.getUid());
            b2.setUser(user);
        }

        //保存待办任务
        this.jpaBackLogTaskDao.save(b2);

        //保存待办任务详情记录
        System.out.println(backLogTaskVo.getUserList().size());
        for(int i=0;i<backLogTaskVo.getUserList().size();i++){
            Backlogtaskdetails bd1=new Backlogtaskdetails();
            JpaSysUser u=backLogTaskVo.getUserList().get(i);
            JpaSysUser user1=this.customerAndUserService.queryByUid(u.getId());
            if(user1!=null){
                bd1.setStatus(1);//待办任务详情状态默认为未完成  完成时间默认为空
                bd1.setUser(user1);
                bd1.setBacklogtask(b2);
                this.jpaBackLogTaskDetailsDao.save(bd1);
            }
        }
    }

    @Override
    public List<Backlogtask> pushBackLogTask(Integer cusId) {
        return this.backLogTaskDao.queryBackLogTaskByCusId(cusId);
    }

    @Override
    public Map queryBackLogTaskByBltId(Integer bltid) {
        Map map=new HashMap();
        List<Backlogtaskdetails> backlogtaskdetailslist=this.backLogTaskDetailsDao.queryBackLogTaskUserBybltId(bltid);
        Backlogtask backlogtask=this.backLogTaskDao.queryBackLogTaskByBltId(bltid);
        map.put("backlogtaskdetailslist",backlogtaskdetailslist);
        map.put("backlogtask",backlogtask);
        return map;
    }

    @Override
    public void finishBackTaskEditDetails(Integer bltid) {
        Backlogtask backlogtask=this.backLogTaskDao.delBackLogQuery(bltid);
        backlogtask.setStatus(2);
        this.jpaBackLogTaskDao.save(backlogtask);
    }

    @Override
    public void delBackLogTaskByBltId(Integer bltid) {
        Backlogtask backlogtask=this.backLogTaskDao.delBackLogQuery(bltid);
        if(backlogtask!=null){
            List<Backlogtaskdetails> backlogtaskdetails=
                    this.backLogTaskDetailsDao.queryBackLogTaskUserBybltId(backlogtask.getBltId());
            this.jpaBackLogTaskDetailsDao.deleteAll(backlogtaskdetails);
            this.backLogTaskDao.deleteBackTaskBltId(bltid);
        }
    }
}
