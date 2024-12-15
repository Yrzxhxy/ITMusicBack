package com.javaclimb.itmusic.controller.User;

import cn.hutool.core.util.StrUtil;
import com.javaclimb.itmusic.common.Constant;
import com.javaclimb.itmusic.pojo.dto.User.UserDTO;
import com.javaclimb.itmusic.pojo.dto.User.UserInfoDTO;
import com.javaclimb.itmusic.pojo.vo.UserVO;
import com.javaclimb.itmusic.service.UserService;
import com.javaclimb.itmusic.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@Api(tags = "用户相关接口")
@RequestMapping("/user")
public class UserController {

    @Autowired
   private UserService userService;

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public ResponseResult userLogin(@RequestBody UserDTO userDTO){
        Map<String,String> data=userService.userLogin(userDTO);
        return ResponseResult.success(Constant.LOGINSUCCESS,data);
    }

    @PostMapping("/userRegist")
    @ApiOperation("用户注册")
    public ResponseResult userRegist(@RequestBody UserDTO userDTO){
        userService.userRegist(userDTO);
        return ResponseResult.success(Constant.REGISTSUCCESS);

    }
    @ApiOperation("依据用户id获取用户信息")
    @GetMapping("/getUserInfo/{userId}")
    public ResponseResult getuserInfoById(@PathVariable("userId") Integer userId){
        UserVO userVO =userService.getUserListById(userId);
        return ResponseResult.success(Constant.SELECTESUCCESS,userVO);
    }

    @PutMapping("/confirmUserInfo")
    @ApiOperation("修改用户信息")
    public ResponseResult confirmUserInfo(@RequestBody UserInfoDTO userInfoDTO){
        userService.updateUserInfo(userInfoDTO);
        return ResponseResult.success(Constant.CONFIRMSUCCESS);
    }

}
