package org.wuliu.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wuliu.dao.GoodsMegDao;
import org.wuliu.entity.GoodsMeg;
import org.wuliu.entity.Knowledge;
import org.wuliu.service.GoodsMegService;

import java.util.List;
@Service
public class GoodsMegServiceImpl  implements GoodsMegService {
    @Autowired
    private GoodsMegDao goodsMegDao;
    @Override
    public List<GoodsMeg> queryAll() {
        return goodsMegDao.queryAll();
    }

    @Override
    public PageInfo<GoodsMeg> findpage(Integer page) {
        PageHelper.startPage(page, 5);
        List<GoodsMeg> list=queryAll();
        return new PageInfo<GoodsMeg>(list);
    }

    @Override
    public GoodsMeg findById(int id) {
        return goodsMegDao.findById(id);
    }
    @Override
    public int insert(String goodsStyle, String goodsNumber, String startProvince, String endProvince, String style, String phone, String remark, String request, String goodsName, String goodsUnit, String startCity, String endCity, String transportTime, String userName,String d) {
        return goodsMegDao.insert(goodsStyle,goodsNumber,startProvince, endProvince,style,phone,
                remark,request, goodsName,
                goodsUnit,startCity,endCity,
                transportTime,userName,d);
    }

    @Override
    public void delete(int id) {
        goodsMegDao.delete(id);
    }

    @Override
    public void update(GoodsMeg goodsMeg) {

        goodsMegDao.update(goodsMeg);
    }
}
