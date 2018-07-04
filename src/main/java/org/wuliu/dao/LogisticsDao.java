package org.wuliu.dao;

import org.wuliu.entity.Logistics;

import java.util.List;

public interface LogisticsDao {
    List<Logistics> findAll();
    Logistics findById(int id);
    void insert(Logistics logistics);
    void delete(int id);
    void update(Logistics logistics);
}
