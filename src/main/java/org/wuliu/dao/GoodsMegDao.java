package org.wuliu.dao;

import org.apache.ibatis.annotations.Param;
import org.wuliu.entity.GoodsMeg;

import java.util.List;

public interface GoodsMegDao {
    List<GoodsMeg> queryAll();
    GoodsMeg findById(int id);

    int insert(@Param("goodsStyle")String goodsStyle,@Param("goodsNumber")String goodsNumber,@Param("startProvince")String startProvince,
               @Param("endProvince")String endProvince,@Param("style")String style,@Param("phone")String phone,
               @Param("remark")String remark,@Param("request")String request,@Param("goodsName")String goodsName,
               @Param("goodsUnit")String goodsUnit,@Param("startCity")String startCity,@Param("endCity")String endCity,
               @Param("transportTime")String transportTime, @Param("link")String link,@Param("userName")String userName);
    int delete(int id);
    int update(GoodsMeg goodsMeg);
}
