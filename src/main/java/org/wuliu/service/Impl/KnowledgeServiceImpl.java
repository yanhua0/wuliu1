package org.wuliu.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wuliu.dao.KnowledgeDao;
import org.wuliu.dao.LogisticsDao;
import org.wuliu.entity.Knowledge;
import org.wuliu.service.KnowledgeService;

import java.util.List;
@Service
public class KnowledgeServiceImpl implements KnowledgeService {
    @Autowired
    private KnowledgeDao knowledgeDao;
    @Override
    public List<Knowledge> findAll() {
        return knowledgeDao.findAll();
    }

    @Override
    public PageInfo<Knowledge> findpage(Integer page) {
        PageHelper.startPage(page, 5);
        List<Knowledge> list=findAll();
        return new PageInfo<Knowledge>(list);
    }

    @Override
    public Knowledge findById(int id) {
        return knowledgeDao.findById(id);
    }

    @Override
    public int insert(Knowledge knowledge) {
        knowledgeDao.insert(knowledge);
        return 1;
    }

    @Override
    public void update(Knowledge knowledge) {
             knowledgeDao.update(knowledge);
    }

    @Override
    public void delete(int id) {
      knowledgeDao.delete(id);
    }
}
