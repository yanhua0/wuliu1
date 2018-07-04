package org.wuliu.dao;

import org.apache.ibatis.annotations.Param;
import org.wuliu.entity.Customer;

public interface CustomerDao {
Customer findByNameAndPassword(@Param("name") String name,@Param("password") String password);

    int insert(@Param("name")String name,@Param("password")String password,@Param("sex")String sex
    ,@Param("phone")String phone,@Param("email")String email,@Param("question")String question,@Param("result")String result,@Param("pow")String pow);
    Customer findByName(@Param("name")String name);

    int update(@Param("password")String password,@Param("name")String name);



}
