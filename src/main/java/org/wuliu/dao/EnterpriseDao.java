package org.wuliu.dao;

import org.apache.ibatis.annotations.Param;
import org.wuliu.entity.Enterprise;

import java.util.List;

public interface EnterpriseDao {
    List<Enterprise> queryAll();
    Enterprise findById(int id);
    int insert(@Param("enterpriseSort")String enterpriseSort,@Param("enterpriseName")String enterpriseName,
    @Param("operation")String operation,@Param("workArea")String workArea,@Param("address")String address,
    @Param("phone")String phone,@Param("linkMan")String linkMan,@Param("handSet")String handSet,@Param("fax")String fax,@Param("email")String email,
               @Param("http")String http,@Param("intro")String intro,@Param("userName")String userName);

    int delete(int id);
    int update(Enterprise enterprise);
}
