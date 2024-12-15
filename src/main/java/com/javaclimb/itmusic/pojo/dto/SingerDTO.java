package com.javaclimb.itmusic.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("歌手DTO")
public class SingerDTO {
    @ApiModelProperty("歌手id")
    private int id;
    @ApiModelProperty(value = "歌手名称",required = true)
    private String name;
    @ApiModelProperty("歌手性别")
    private byte sex;
    @ApiModelProperty("歌手图片")
    private String pic;
    @ApiModelProperty("歌手生日")
    private Date birth;
    @ApiModelProperty("歌手地区")
    private  String location;
    @ApiModelProperty("歌手介绍")
    private String introduction;
}
