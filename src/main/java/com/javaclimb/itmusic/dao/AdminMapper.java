package com.javaclimb.itmusic.dao;

import com.javaclimb.itmusic.pojo.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/*
* 管理员DAO
* */

@Mapper
public interface AdminMapper {
    /*
    * 验证密码是否正确
    * */
     Admin verifyPassword(@Param("name") String name, @Param("password") String password);


    /*
    * 注册
    * */
    boolean registAdmin(@Param("userForm") Admin admin);
}
