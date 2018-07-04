package org.wuliu.service;

import com.github.pagehelper.PageInfo;
import org.wuliu.entity.Enterprise;
import org.wuliu.entity.GoodsMeg;


import java.util.List;

public interface EnterpriseService {
    List<Enterprise> queryAll();
    PageInfo<Enterprise> findpage(Integer page);
    Enterprise findById(int id);
    int insert(String enterpriseSort,String enterpriseName,String operation,String workArea,String address,String phone,String linkMan,String handSet,
            String fax,String email,String http,String intro,String userName);
    void delete(int id);
    void update(Enterprise enterprise);
};
