package com.javaclimb.itmusic.dao;

import com.javaclimb.itmusic.pojo.dto.AddSongDTO;
import com.javaclimb.itmusic.pojo.dto.SongDTO;
import com.javaclimb.itmusic.pojo.vo.SingerVO;
import com.javaclimb.itmusic.pojo.vo.SongVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper

public interface SongMapper {
    /**
     * 添加歌曲
     * @param addSongDTO
     * @return
     */
    int addSong(AddSongDTO addSongDTO);

    /**
     * 获取全部歌曲列表（分夜查）
     * @param startIndex
     * @param size
     * @return
     */
    List<SongVO> Songlist(@Param("startIndex") Integer startIndex, @Param("size") Integer size );

    /**
     * 查歌曲总数
     * @return
     */
    @Select("select  count(*) from song")
    Long SelectSongCount();

    /**
     * 依据歌手id查歌曲
     * @param singerId
     * @return
     */
    List<SongVO> SongListById(@Param("singerId") Integer singerId,@Param("startIndex") Integer startIndex,@Param("size") Integer size);

    /**
     * 查歌曲总数
     * @return
     */
    @Select("select  count(*) from song where id=#{id}")
    Long SelectSongCountById(Integer id);

    /**
     * 删除歌曲
     * @param songId
     * @return
     */
    @Delete("delete from song where id=#{songId}")
    int deleteSongById(Integer songId);

    int updateSong(SongDTO songDTO);
}
