package com.javaclimb.itmusic.dao;

import com.javaclimb.itmusic.pojo.vo.SongVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CollectionMapper {

    int addSongTo(@Param("userId") Integer userId,@Param("songId") Integer songId,@Param("type") Integer type);

    int addSongListTo(@Param("userId")Integer userId,@Param("songListId")  Integer songListId,@Param("type")  Integer type);

    @Select("select COUNT(*) from collect where user_id=#{userId} and song_id=#{songId}")
    int isSongExist(@Param("userId")Integer userId, @Param("songId")Integer songId);

    @Select("select COUNT(*) from collect where user_id=#{userId} and song_list_id=#{songListId}")
    int isSongListExist(@Param("userId")Integer userId,@Param("songListId") Integer songListId);

    @Select("select * from collect where user_id=#{userId} and type=#{type}")
    List<SongVO> getCollect(@Param("userId")Integer userId, @Param("type")Integer type);
}
