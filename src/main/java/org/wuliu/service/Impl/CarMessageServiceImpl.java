package org.wuliu.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wuliu.dao.CarMessageDao;
import org.wuliu.entity.CarMessage;
import org.wuliu.entity.Knowledge;
import org.wuliu.service.CarMessageService;
import java.util.List;

@Service
public class CarMessageServiceImpl implements CarMessageService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CarMessageDao carMessageDao;
    @Override
    public List<CarMessage> queryAll() {
        return carMessageDao.queryAll();
    }

    @Override
    public PageInfo<CarMessage> findpage(Integer page) {
        PageHelper.startPage(page, 5);
        List<CarMessage> list=queryAll();
        logger.info("车辆信息查询-------");
        return new PageInfo<CarMessage>(list);

    }

    @Override
    public CarMessage findById(int id) {
        return carMessageDao.findById(id);
    }

    @Override
    public int insert(String licenceNumber, String driverName, String driverTime, String userName, String userTime, String linkPhone, String remark, String licenceStyle, String carLoad, String transpotStyle, String tradeMark, String style, String linkMan,String name) {
        return carMessageDao.insert(licenceNumber,driverName,driverTime
                ,userName,userTime,linkPhone,remark,licenceStyle,carLoad,transpotStyle,tradeMark,style,linkMan,name);
    }

    @Override
    public void delete(int id) {
        logger.warn("删除"+id+"的车辆信息!!!");

        carMessageDao.delete(id);
    }

    @Override
    public void update(CarMessage carMessage) {
        logger.warn("更新"+carMessage+"信息！");
        carMessageDao.update(carMessage);
    }
}
