package com.javaclimb.itmusic.pojo.vo;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchResultVO {
    //歌手
    private List<SingerVO> singerList;
    //歌曲
    private List<SongVO> songVOList;

}
