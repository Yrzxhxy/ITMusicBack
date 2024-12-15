package com.javaclimb.itmusic.pojo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Collect {
    private Integer id;
    private Integer userId;
    private Integer type;
    private Integer songId;
    private Integer songListId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date creatDate;

}
