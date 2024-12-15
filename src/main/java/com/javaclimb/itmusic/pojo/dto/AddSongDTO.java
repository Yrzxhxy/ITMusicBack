package com.javaclimb.itmusic.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "添加歌曲DTO")
public class AddSongDTO {
    @ApiModelProperty(value = "歌手id",required = true)
    private Integer singerId;
    @ApiModelProperty(value = "歌曲名称",required = true)
    private String name;
    @ApiModelProperty("歌曲介绍")
    private String introduction;
    @ApiModelProperty("歌曲图片")
    private String pic;
    @ApiModelProperty("歌曲歌词")
    private String lyric;
    @ApiModelProperty("歌曲地址")
    private String url;
}
