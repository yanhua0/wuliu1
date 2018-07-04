package org.wuliu.dao;

import org.wuliu.entity.Placard;

import java.util.List;

public interface PlacardDao {
    List<Placard> findAll();
    void insert(Placard placard);
    void update(Placard placard);
    Placard findById(int id);
    void delete(int id);
}
