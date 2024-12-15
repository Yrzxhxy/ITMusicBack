package com.javaclimb.itmusic.pojo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Integer id;

    private String userName;
    private String passWord;
    private String nickName;
    private int sex;
    private String phoneNum;
    private String email;
    private String introduction;
    private String location;
    private String avator;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date creatTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;

}
