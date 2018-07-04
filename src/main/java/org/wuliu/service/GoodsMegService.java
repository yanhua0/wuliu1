package org.wuliu.service;

import com.github.pagehelper.PageInfo;
import org.wuliu.entity.GoodsMeg;
import org.wuliu.entity.Knowledge;

import java.util.List;

public interface GoodsMegService {
    List<GoodsMeg> queryAll();
    PageInfo<GoodsMeg> findpage(Integer page);
    GoodsMeg findById(int id);
    int insert(String goodsStyle,String goodsNumber,String startProvince,
               String endProvince,String style,String phone,
               String remark,String request,String goodsName,
               String goodsUnit,String startCity,String endCity,
               String transportTime,String userName,String d);
    void delete(int id);
    void update(GoodsMeg goodsMeg);
}
