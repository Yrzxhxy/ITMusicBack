package com.javaclimb.itmusic.service;

import com.javaclimb.itmusic.pojo.dto.User.UserDTO;
import com.javaclimb.itmusic.pojo.dto.User.UserInfoDTO;
import com.javaclimb.itmusic.pojo.vo.UserVO;

import java.util.List;
import java.util.Map;

public interface UserService {
    Map<String, String> userLogin(UserDTO userDTO);

    /**
     * 用户注册
     * @param userDTO
     */
    void userRegist(UserDTO userDTO);

    /**
     * 依据用户ID返回用户信息
     * @param userId
     * @return
     */
    UserVO getUserListById(Integer userId);


    /**
     * 修改用户信息
     * @param userInfoDTO
     */
    void updateUserInfo(UserInfoDTO userInfoDTO);
}
