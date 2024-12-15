package com.javaclimb.itmusic.dao;

import com.javaclimb.itmusic.pojo.vo.ListSongVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ListSongMapper {

    int addSongToList(@Param("songId") Integer songId,@Param("listId") Integer listId);

    ListSongVO getListSong(Integer songListId);
}
