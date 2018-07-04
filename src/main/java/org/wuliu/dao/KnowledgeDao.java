package org.wuliu.dao;

import org.apache.ibatis.annotations.Param;
import org.wuliu.entity.Knowledge;

import java.util.List;

public interface KnowledgeDao {
    List<Knowledge> findAll();
    Knowledge findById(int id);
    int insert(Knowledge knowledge);
    void update(Knowledge knowledge);
    void delete(int id);
}
