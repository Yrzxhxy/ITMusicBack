package com.javaclimb.itmusic.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("添加歌手DTO")
public class AddSingerDTO {
    @ApiModelProperty(value = "歌手名字",required = true)
    private String name;
    @ApiModelProperty("歌手性别")
    private byte sex;
    @ApiModelProperty("歌手图片")
    private String pic;
    @ApiModelProperty("歌手生日")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    @ApiModelProperty("歌手地区")
    private  String location;
    @ApiModelProperty("歌手简介")
    private String introduction;
}
