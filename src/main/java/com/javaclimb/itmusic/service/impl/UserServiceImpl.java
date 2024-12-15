package com.javaclimb.itmusic.service.impl;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.MD5;
import com.javaclimb.itmusic.common.Constant;
import com.javaclimb.itmusic.dao.UserMapper;
import com.javaclimb.itmusic.exception.CustomException;
import com.javaclimb.itmusic.pojo.dto.User.UserDTO;
import com.javaclimb.itmusic.pojo.dto.User.UserInfoDTO;
import com.javaclimb.itmusic.pojo.vo.UserVO;
import com.javaclimb.itmusic.service.UserService;
import com.javaclimb.itmusic.utils.JWTUtils;
import com.javaclimb.itmusic.utils.enums.HttpCodeEnum;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.javaclimb.itmusic.utils.enums.HttpCodeEnum.ERROR;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    /**
     * @param userDTO
     * @return
     */
    @Override
    public Map<String, String> userLogin(UserDTO userDTO) {
        Map<String, String> data = new HashMap<>();
        if (userDTO.getUserName() != null && userDTO.getPassword() != null && userDTO.getPassword()
                != "" && userDTO.getUserName() != "") {
//            查询用户信息是否匹配，并返回用户ID
//            userDTO.getPassword();
            MD5 md5 =new MD5();
            Integer userId = userMapper.userLogin(userDTO.getUserName(),  md5.digest(userDTO.getPassword()).toString());
            if (userId != null) {
                Map<String, String> addToken = new HashMap<>();
                addToken.put("userId", Integer.toString(userId));
                addToken.put("userName", userDTO.getUserName());
                String token = JWTUtils.getToken(addToken);
                data.put("userId", Integer.toString(userId));
                data.put("token", token);
                return data;
            }
        }
        throw new CustomException(Constant.FAILCODE, Constant.PARAMETERFAIL);
    }

    /**
     * 用户注册
     *
     * @param userDTO
     */
    @Override
    public void userRegist(UserDTO userDTO) {
        if (userDTO.getUserName() != null && userDTO.getUserName() != "" && userDTO.getPassword() != null && userDTO.getPassword() != "") {
            //密码加盐
            MD5 md5=new MD5();
            byte[] digest = md5.digest(userDTO.getPassword());
            int isAdd = userMapper.addUser(userDTO.getUserName(), digest.toString());
            if (isAdd < 1) {
                throw new CustomException(Constant.FAILCODE, Constant.REGISTFAIL);
            }
        }
        throw new CustomException(Constant.FAILCODE, Constant.PARAMETERFAIL);

    }

    /**
     * 依据用户ID返回用户信息
     *
     * @param userId
     * @return
     */
    @Override
    public UserVO getUserListById(Integer userId) {
        UserVO userVO = userMapper.selectInfo(userId);
        if (userVO != null) {
            return userVO;
        }
        throw new CustomException(Constant.FAILCODE, Constant.SELECTEFAIL);
    }

    /**
     * 修改用户信息
     *
     * @param userInfoDTO
     */
    @Override
    public void updateUserInfo(UserInfoDTO userInfoDTO) {
        if (userInfoDTO.getId() == null) {
            throw new CustomException(Constant.FAILCODE, Constant.PARAMETERFAIL);
        }
        int isupdate = userMapper.updateUserInfo(userInfoDTO);
        if (isupdate < 1) {
            throw new CustomException(Constant.FAILCODE, Constant.UPDATEFAIL);
        }

    }
}
