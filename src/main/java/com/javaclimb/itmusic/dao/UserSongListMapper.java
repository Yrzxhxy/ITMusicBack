package com.javaclimb.itmusic.dao;

import com.javaclimb.itmusic.pojo.vo.ListSongVO;
import com.javaclimb.itmusic.pojo.vo.SongListVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserSongListMapper {
    List<SongListVO> getSongList(@Param("startIndex") int startIndex,@Param("size") Integer size);

    @Select("select count(*) from song_list")
    Long getSongListCounts();

    ListSongVO getListSong(Integer songListId);
}
