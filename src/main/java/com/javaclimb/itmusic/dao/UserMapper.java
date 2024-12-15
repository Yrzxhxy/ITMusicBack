package com.javaclimb.itmusic.dao;

import com.javaclimb.itmusic.pojo.dto.User.UserDTO;
import com.javaclimb.itmusic.pojo.dto.User.UserInfoDTO;
import com.javaclimb.itmusic.pojo.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    Integer userLogin(@Param("userName") String userName,@Param("passWord") String passWord);

    int addUser(@Param("userName") String userName, @Param("passWord") String password);

//    @Select("select * from consumer where id=#{userId}")
    UserVO selectInfo(Integer userId);


    int updateUserInfo(UserInfoDTO userInfoDTO);
}
