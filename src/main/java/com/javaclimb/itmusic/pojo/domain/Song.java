package com.javaclimb.itmusic.pojo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


@Data
public class Song {
    private int id;
    private int singerId;
    private String name;
    private String introduction;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;
    private String pic;
    private String lynic;
    private String url;
}
