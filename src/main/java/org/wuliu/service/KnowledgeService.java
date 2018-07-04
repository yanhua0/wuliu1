package org.wuliu.service;

import com.github.pagehelper.PageInfo;
import org.wuliu.entity.Knowledge;
import org.wuliu.entity.Logistics;

import java.util.List;

public interface KnowledgeService {
    List<Knowledge> findAll();
    PageInfo<Knowledge> findpage(Integer page);
    Knowledge findById(int id);
    int insert(Knowledge knowledge);
    void update(Knowledge knowledge);
    void delete(int id);
}
