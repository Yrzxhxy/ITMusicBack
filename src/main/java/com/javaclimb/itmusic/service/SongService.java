package com.javaclimb.itmusic.service;

import com.javaclimb.itmusic.pojo.PageBean;
import com.javaclimb.itmusic.pojo.dto.AddSongDTO;
import com.javaclimb.itmusic.pojo.dto.SongDTO;
import com.javaclimb.itmusic.pojo.vo.SongVO;

public interface SongService {

    /**
     * 添加歌曲
     * @param addSongDTO
     */
    void addSong(AddSongDTO addSongDTO);

    /**
     * 查询全部歌曲(分页)
     * @return
     */
    PageBean selectAllSong(Integer startIndex,Integer page);

    /**
     * 依据歌手id查歌曲
     * @param singerId
     * @return
     */
    PageBean seletcListById(Integer singerId,Integer page,Integer size);

    void deleteSong(Integer songId);

    /**
     * 修改歌曲信息
     * @param songDTO
     */
    void updateSong(SongDTO songDTO);
}
