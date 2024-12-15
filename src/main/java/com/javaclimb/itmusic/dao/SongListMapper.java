package com.javaclimb.itmusic.dao;

import com.javaclimb.itmusic.pojo.domain.SongList;
import com.javaclimb.itmusic.pojo.dto.SongListDTO;
import com.javaclimb.itmusic.pojo.vo.SongListVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SongListMapper {

    int createSongList(SongListDTO songListDTO);

    @Select("select * from song_list")
    List<SongListVO> getSongList();

    int updateSongList(SongList songList);

    @Delete("delete from song_list where id=#{songListId}")
    int deleteSongList(Integer songListId);
}
