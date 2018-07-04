package org.wuliu.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wuliu.dao.PlacardDao;

import org.wuliu.entity.Placard;
import org.wuliu.service.PlacardSerivce;

import java.util.List;
@Service
public class PlacardSerivceImpl implements PlacardSerivce {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PlacardDao placardDao;
    @Override
    public List<Placard> findAll() {
       return placardDao.findAll();
    }

    @Override
    public void insert(Placard placard) {
        placardDao.insert(placard);
    }

    @Override
    public void update(Placard placard) {
        placardDao.update(placard);
    }

    @Override
    public Placard findById(int id) {
     return   placardDao.findById(id);
    }

    @Override
    public void delete(int id) {
         Placard placard1=placardDao.findById(id);
         if (placard1!=null){
             placardDao.delete(id);
         }
         logger.error("错误的id="+id);
    }

    @Override
    public PageInfo<Placard> findpage(Integer page) {
        PageHelper.startPage(page, 5);
        List<Placard> list=findAll();
        return new PageInfo<Placard>(list);
    }
}
