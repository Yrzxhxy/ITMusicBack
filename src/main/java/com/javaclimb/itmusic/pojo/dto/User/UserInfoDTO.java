package com.javaclimb.itmusic.pojo.dto.User;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户DTO")
public class UserInfoDTO {
    @ApiModelProperty(value = "用户id",required = true)
    private Integer id;
    @ApiModelProperty("用户昵称")
    private String nickName;
    @ApiModelProperty("用户性别")
    private Integer sex;
    @ApiModelProperty("用户手机号")
    private String phoneNum;
    @ApiModelProperty("用户邮箱")
    private String email;
    @ApiModelProperty("用户简介")
    private String introduction;
    @ApiModelProperty("用户地址")
    private String location;
    @ApiModelProperty("用户头像")
    private String avator;
    @ApiModelProperty("用户生日")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birth;
}
