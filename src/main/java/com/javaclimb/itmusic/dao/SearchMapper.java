package com.javaclimb.itmusic.dao;

import com.javaclimb.itmusic.pojo.vo.SingerVO;
import com.javaclimb.itmusic.pojo.vo.SongVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SearchMapper {

    List<SingerVO> searchSinger(String keywords);

    List<SongVO> searchSongs(String keywords);
}
