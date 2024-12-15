package com.javaclimb.itmusic.service;

import com.javaclimb.itmusic.pojo.domain.Admin;
import com.javaclimb.itmusic.pojo.dto.AdminDTO;

/*
 管理员service接口
 */
public interface AdminService {
        /*
        * 验证密码是否正确 管理员登录
        * */
        Admin verifyPassword(AdminDTO adminDTO);

        /*
        * 管理员注册账号
        * */
        Boolean regist(AdminDTO adminDTO);


}
