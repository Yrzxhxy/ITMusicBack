package com.javaclimb.itmusic.service.impl;

import com.javaclimb.itmusic.common.Constant;
import com.javaclimb.itmusic.dao.ListSongMapper;
import com.javaclimb.itmusic.dao.SongListMapper;
import com.javaclimb.itmusic.exception.CustomException;
import com.javaclimb.itmusic.pojo.domain.SongList;
import com.javaclimb.itmusic.pojo.dto.SongListDTO;
import com.javaclimb.itmusic.pojo.vo.ListSongVO;
import com.javaclimb.itmusic.pojo.vo.SongListVO;
import com.javaclimb.itmusic.service.SongListService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongListServiceImpl  implements SongListService {


    @Autowired
    private SongListMapper songListMapper;
    @Autowired
    private ListSongMapper listSongMapper;

    /**
     * 创建歌单
     * @param songListDTO
     */
    @Override
    public void createSongList(SongListDTO songListDTO) {
        if(songListDTO.getTitle()==null&&songListDTO.getTitle()==""){throw new CustomException(Constant.FAILCODE,Constant.PARAMETERFAIL);}
        int isCreate=songListMapper.createSongList(songListDTO);
        if(isCreate<1){
            throw new CustomException(Constant.FAILCODE,Constant.ADDFAIL);
        }

    }

    /**
     * 添加歌曲至歌单
     *
     * @param songId
     * @param listId
     */
    @Override
    public void addSongToList(Integer songId, Integer listId) {
        if(songId==null||listId==null){throw new CustomException(Constant.FAILCODE,Constant.PARAMETERFAIL);}
        int isAdd=listSongMapper.addSongToList(songId,listId);
        if(isAdd<1){throw new CustomException(Constant.FAILCODE,Constant.ADDFAIL);}

    }

    /**
     * 查询歌单列表
     * @return
     */
    @Override
    public List<SongListVO> getSongList() {
        List<SongListVO> list =songListMapper.getSongList();
        return list;
    }

    /**
     * @param songListId
     * @return
     */
    @Override
    public  ListSongVO getSongFromList(Integer songListId) {
        if(songListId==null){throw new CustomException(Constant.FAILCODE,Constant.PARAMETERFAIL);}
//        依据歌单id查询歌单内包含的歌曲
       ListSongVO listSongVO=listSongMapper.getListSong(songListId);
        return listSongVO;
    }

    /**
     * 更新歌单信息
     * @param songList
     */
    @Override
    public void updateSongList(SongList songList) {
        if (songList.getId()!=null){throw new CustomException(Constant.FAILCODE,Constant.PARAMETERFAIL);}
        int isUpdate=songListMapper.updateSongList(songList);
        if(isUpdate<1){throw new CustomException(Constant.FAILCODE,Constant.UPDATEFAIL);}
    }

    /**删除歌单
     * @param songListId
     */
    @Override
    public void deleteSongList(Integer songListId) {
        if(songListId==null){throw new CustomException(Constant.FAILCODE,Constant.PARAMETERFAIL);}
        int isDeleted=songListMapper.deleteSongList(songListId);
        if(isDeleted<1){throw  new CustomException(Constant.FAILCODE,Constant.DELETEFAIL);}
    }
}
