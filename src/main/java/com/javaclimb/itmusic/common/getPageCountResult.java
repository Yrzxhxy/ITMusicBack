package com.javaclimb.itmusic.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

@Data
@NoArgsConstructor

public class getPageCountResult {

    private Integer page;
    private Integer size;

    public  getPageCountResult(Integer _page, Integer _size) {
        this.page = _page != null ? _page : 1;
        this.size = _size != null ? _size : 10;


    }
    public int getStartIndex(){
        return (getPage()-1)*getSize();
    }

}
