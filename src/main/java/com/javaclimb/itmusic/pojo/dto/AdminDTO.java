package com.javaclimb.itmusic.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel("表单DTO")
public class AdminDTO {
    @ApiModelProperty("用户名")
    private  String name;

    @ApiModelProperty("密码")
    //    密码
    private  String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
