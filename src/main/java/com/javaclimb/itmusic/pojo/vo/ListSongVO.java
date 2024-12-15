package com.javaclimb.itmusic.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ListSongVO {
//    歌单ID
    private Integer songListId;
    @ApiModelProperty("歌单名称")
    private String title;
    @ApiModelProperty("歌单图片")
    private String pic;
    @ApiModelProperty("歌单简介")
    private String introduc;
    @ApiModelProperty("歌单风格")
    private String style;
    //    歌曲实体
    private List<SongVO> songList;
}
