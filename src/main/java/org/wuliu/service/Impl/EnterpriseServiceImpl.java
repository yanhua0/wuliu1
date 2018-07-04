package org.wuliu.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wuliu.dao.EnterpriseDao;
import org.wuliu.entity.Enterprise;
import org.wuliu.entity.Knowledge;
import org.wuliu.service.EnterpriseService;

import java.util.List;
@Service
public class EnterpriseServiceImpl implements EnterpriseService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private EnterpriseDao enterpriseDao;
    @Override
    public List<Enterprise> queryAll() {
        return enterpriseDao.queryAll();
    }

    @Override
    public PageInfo<Enterprise> findpage(Integer page) {
        PageHelper.startPage(page, 5);
        List<Enterprise> list=queryAll();
        logger.info("企业信息查询成功!");
        return new PageInfo<Enterprise>(list);
    }

    @Override
    public Enterprise findById(int id) {
        return enterpriseDao.findById(id);
    }

    @Override
    public int insert(String enterpriseSort, String enterpriseName, String operation, String workArea, String address, String phone, String linkMan, String handSet, String fax,String email, String http, String intro, String userName) {
        logger.info("新增企业信息！");
        return enterpriseDao.insert(enterpriseSort,enterpriseName,operation,workArea,address,phone,linkMan,handSet,
                fax,email,http,intro,userName);
    }

    @Override
    public void delete(int id)
    {   logger.warn("删出企业信息！"+id);
        enterpriseDao.delete(id);
    }

    @Override
    public void update(Enterprise enterprise) {
        logger.warn("更新企业信息！"+enterprise);

        enterpriseDao.update(enterprise);
    }
}
