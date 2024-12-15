package com.javaclimb.itmusic.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class SingerVO {
    private int id;
    private String name;
    private byte sex;
    private String pic;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    private  String location;
    private String introduction;
}
