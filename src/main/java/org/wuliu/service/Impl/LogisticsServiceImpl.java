package org.wuliu.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wuliu.dao.LogisticsDao;
import org.wuliu.entity.Logistics;
import org.wuliu.service.LogisticsService;

import java.util.List;
@Service
public class LogisticsServiceImpl implements LogisticsService {
    @Autowired
    private LogisticsDao logisticsDao;
    @Override
    public List<Logistics> findAll() {
       return logisticsDao.findAll();
    }

    @Override
    public PageInfo<Logistics> findpage(Integer page) {
        PageHelper.startPage(page, 5);
        List<Logistics> list=findAll();
        return new PageInfo<Logistics>(list);
    }

    @Override
    public Logistics findById(int id) {
        return logisticsDao.findById(id);
    }

    @Override
    public int insert(Logistics logistics) {
        logisticsDao.insert(logistics);
        return 1;
    }

    @Override
    public void update(Logistics logistics) {
        logisticsDao.update(logistics);
    }

    @Override
    public void delete(int id) {
       logisticsDao.delete(id);
    }
}
