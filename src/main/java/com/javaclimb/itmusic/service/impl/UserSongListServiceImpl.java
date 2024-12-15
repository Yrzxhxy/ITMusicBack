package com.javaclimb.itmusic.service.impl;

import com.javaclimb.itmusic.common.Constant;
import com.javaclimb.itmusic.common.getPageCountResult;
import com.javaclimb.itmusic.dao.UserSongListMapper;
import com.javaclimb.itmusic.exception.CustomException;
import com.javaclimb.itmusic.pojo.PageBean;
import com.javaclimb.itmusic.pojo.vo.ListSongVO;
import com.javaclimb.itmusic.pojo.vo.SongListVO;
import com.javaclimb.itmusic.pojo.vo.SongVO;
import com.javaclimb.itmusic.service.UserSongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSongListServiceImpl implements UserSongListService {

    @Autowired
    private UserSongListMapper userSongListMapper;

    /**
     * 获取歌单列表(分页)
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageBean getSongList(Integer page, Integer size) {
        getPageCountResult getPageCountResult = new getPageCountResult(page,size);
        List<SongListVO> songs = userSongListMapper.getSongList(getPageCountResult.getStartIndex(), getPageCountResult.getSize());
        PageBean pageBean=new PageBean(userSongListMapper.getSongListCounts(),songs);
        return pageBean;
    }

    /**
     * @param songListId
     * @return
     */
    @Override
    public  ListSongVO getSongFromList(Integer songListId) {
        if(songListId==null){throw new CustomException(Constant.FAILCODE,Constant.PARAMETERFAIL);}
//        依据歌单id查询歌单内包含的歌曲
        ListSongVO listSongVO=userSongListMapper.getListSong(songListId);
        return listSongVO;
    }
}
