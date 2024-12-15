package com.javaclimb.itmusic.service;


import com.javaclimb.itmusic.pojo.PageBean;
import com.javaclimb.itmusic.pojo.vo.ListSongVO;
import com.javaclimb.itmusic.pojo.vo.SongListVO;

import java.util.List;

public interface UserSongListService {
    /**
     * 获取歌单列表
     * @return
     */

    PageBean getSongList(Integer page, Integer size);

    ListSongVO getSongFromList(Integer songListId);
}
