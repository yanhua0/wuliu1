package org.wuliu.service;

import com.github.pagehelper.PageInfo;
import org.wuliu.entity.Knowledge;
import org.wuliu.entity.Logistics;

import java.util.List;

public interface LogisticsService {
    List<Logistics> findAll();
    PageInfo<Logistics> findpage(Integer page);
    Logistics findById(int id);
    int insert(Logistics logistics);
    void update(Logistics logistics);
    void delete(int id);
}
