package com.javaclimb.itmusic.controller.Admin;

import com.javaclimb.itmusic.common.Constant;
import com.javaclimb.itmusic.pojo.domain.Admin;
import com.javaclimb.itmusic.pojo.dto.AdminDTO;
import com.javaclimb.itmusic.service.AdminService;
import com.javaclimb.itmusic.utils.JWTUtils;
import com.javaclimb.itmusic.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static com.javaclimb.itmusic.utils.enums.HttpCodeEnum.RC107;

@Slf4j
@RestController
@Api(tags = "管理员相关接口")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    /*
    * 判断是否登录成功
    * */
    @ApiOperation(value = "管理员登录")
    @PostMapping (value = "/login")
    public ResponseResult login(@RequestBody AdminDTO adminDTO){
        Admin admin = adminService.verifyPassword(adminDTO);
        /*
        * @todo md5加密
        * */
        if(admin==null){
           return ResponseResult.fail(RC107);
        }
        String name=admin.getName();
        Integer id=admin.getId();
        Map<String,String> map=new HashMap<>();
        map.put("name",name);
        map.put("userId", String.valueOf(id));
        String token = JWTUtils.getToken(map);
        if(token!=""){
          Map<String,String> result=new HashMap<>();
          result.put("token",token);
          result.put("userId",String.valueOf(id));
           return ResponseResult.success(Constant.LOGINSUCCESS,result);
        }

    return  ResponseResult.fail();
    }


    /**
     *
     * @param adminDTO
     * @return
     */
    @ApiOperation(value = "添加管理员账号")
    @PostMapping(value = "/regist")
    public ResponseResult regist(@RequestBody AdminDTO adminDTO){

      adminService.regist(adminDTO);
        return ResponseResult.success(Constant.ADDSUCCESS);
    }


}
