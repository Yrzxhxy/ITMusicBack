package com.javaclimb.itmusic.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel(value = "歌单DTO")
public class SongListDTO {
    @ApiModelProperty(value = "歌单名称",required = true)
    private String title;
    @ApiModelProperty(value = "歌单图片")
    private String pic;
    @ApiModelProperty(value = "歌单介绍")
    private String introduc;
    @ApiModelProperty(value = "歌单风格")
    private String style;

}
