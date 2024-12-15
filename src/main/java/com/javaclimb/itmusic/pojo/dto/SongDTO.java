package com.javaclimb.itmusic.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "歌曲DTO")
public class SongDTO {
    @ApiModelProperty(value = "歌曲id",required = true)
    private Integer id;
    @ApiModelProperty(value = "歌手id")
    private Integer singerId;
    @ApiModelProperty(value = "歌曲名称")
    private String name;
    @ApiModelProperty("歌曲介绍")
    private String introduction;
    @ApiModelProperty("歌曲图片")
    private String pic;
    @ApiModelProperty("歌曲歌词")
    private String lynic;
    @ApiModelProperty("歌曲地址")
    private String url;
}
