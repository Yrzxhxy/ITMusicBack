package com.javaclimb.itmusic.pojo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class SongList {
    private Integer id;
    private String title;
    private String pic;
    private String introduc;
    private String style;
}
