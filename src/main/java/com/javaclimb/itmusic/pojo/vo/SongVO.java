package com.javaclimb.itmusic.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongVO {
//    歌曲id
    private int id;
//    歌手id
    private int singerId;
//    歌曲名
    private String name;
//    歌曲简介
    private String introduction;
    private String pic;
    private String lynic;
    private String url;
}
