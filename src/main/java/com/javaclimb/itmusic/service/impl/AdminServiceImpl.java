package com.javaclimb.itmusic.service.impl;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.javaclimb.itmusic.dao.AdminMapper;
import com.javaclimb.itmusic.pojo.domain.Admin;
import com.javaclimb.itmusic.pojo.dto.AdminDTO;
import com.javaclimb.itmusic.service.AdminService;
import com.javaclimb.itmusic.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * @param adminDTO
     * @return
     */
    @Override
    public Admin verifyPassword(AdminDTO adminDTO) {
        Admin admin = adminMapper.verifyPassword(adminDTO.getName(), adminDTO.getPassword());

        return admin;
    }

    /**
     * @param adminDTO
     *
     * 注册
     * @return
     */
    @Override
    public Boolean regist(AdminDTO adminDTO) {

        return null;
    }


}
