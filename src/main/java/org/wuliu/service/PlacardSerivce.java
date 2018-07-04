package org.wuliu.service;

import com.github.pagehelper.PageInfo;
import org.wuliu.entity.Customer;
import org.wuliu.entity.Placard;

import java.util.List;

public interface PlacardSerivce {
    List<Placard> findAll();
    void insert(Placard placard);
    void update(Placard placard);
    Placard findById(int id);
    void delete(int id);
    PageInfo<Placard> findpage(Integer page);
}
