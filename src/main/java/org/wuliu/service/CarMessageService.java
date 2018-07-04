package org.wuliu.service;

import com.github.pagehelper.PageInfo;
import org.wuliu.entity.CarMessage;
import org.wuliu.entity.GoodsMeg;

import java.util.List;

public interface CarMessageService {
    List<CarMessage> queryAll();
    PageInfo<CarMessage> findpage(Integer page);
    CarMessage findById(int id);
    int insert(String licenceNumber,String driverName,String driverTime
            ,String userName,String userTime,String linkPhone,
               String remark,String licenceStyle,String carLoad, String transpotStyle,
               String tradeMark,String style,String linkMan,String name);
    void delete(int id);
    void update(CarMessage carMessage);
}
