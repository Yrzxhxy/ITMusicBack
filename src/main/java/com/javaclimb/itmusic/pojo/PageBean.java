package com.javaclimb.itmusic.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageBean {
//    总记录数
    private Long total;
//    数据
    private List rows;


}
