package com.javaclimb.itmusic.service;


import com.javaclimb.itmusic.pojo.domain.SongList;
import com.javaclimb.itmusic.pojo.dto.SongListDTO;
import com.javaclimb.itmusic.pojo.vo.ListSongVO;
import com.javaclimb.itmusic.pojo.vo.SongListVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SongListService {

    void createSongList(SongListDTO songListDTO);

    /**
     * 添加歌曲至歌单
     * @param songId
     * @param listId
     */
    void addSongToList(Integer songId, Integer listId);


    List<SongListVO> getSongList();

    ListSongVO getSongFromList(Integer songListId);

    void updateSongList(SongList songList);

    void deleteSongList(Integer songListId);
}
