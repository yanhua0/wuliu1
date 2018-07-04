package org.wuliu.dao;

import org.apache.ibatis.annotations.Param;
import org.wuliu.entity.CarMessage;

import java.util.List;

public interface CarMessageDao {
    List<CarMessage> queryAll();
    CarMessage findById(int id);
    int insert(@Param("licenceNumber")String licenceNumber,
               @Param("driverName")String driverName,@Param("driverTime")String driverTime,
               @Param("brand")String brand,@Param("userTime")String userTime,@Param("linkPhone")String linkPhone,
               @Param("remark")String remark,@Param("licenceStyle")String licenceStyle,@Param("carLoad")String carLoad,
               @Param("transpotStyle")String transpotStyle,@Param("tradeMark")String tradeMark,
               @Param("style")String style,@Param("linkMan")String linkMan,@Param("userName")String
               userName);

    int delete(int id);
    int update(CarMessage carMessage);
}
