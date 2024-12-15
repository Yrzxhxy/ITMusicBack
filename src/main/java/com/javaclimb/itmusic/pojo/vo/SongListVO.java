package com.javaclimb.itmusic.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SongListVO {
    @ApiModelProperty("歌单id")
    private Integer id;
    @ApiModelProperty("歌单名称")
    private String title;
    @ApiModelProperty("歌单图片")
    private String pic;
    @ApiModelProperty("歌单简介")
    private String introduc;
    @ApiModelProperty("歌单风格")
    private String style;

}
