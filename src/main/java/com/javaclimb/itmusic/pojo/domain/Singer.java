package com.javaclimb.itmusic.pojo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 歌手
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Singer {
    private int id;
    private String name;
    private byte sex;
    private String pic;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    private  String location;
    private String introduction;


}
