package com.javaclimb.itmusic.service.impl;

import com.javaclimb.itmusic.common.Constant;
import com.javaclimb.itmusic.common.getPageCountResult;
import com.javaclimb.itmusic.dao.SongMapper;
import com.javaclimb.itmusic.exception.CustomException;
import com.javaclimb.itmusic.pojo.PageBean;
import com.javaclimb.itmusic.pojo.dto.AddSongDTO;
import com.javaclimb.itmusic.pojo.dto.SongDTO;
import com.javaclimb.itmusic.pojo.vo.SingerVO;
import com.javaclimb.itmusic.pojo.vo.SongVO;
import com.javaclimb.itmusic.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    @Autowired
    private SongMapper songMapper;

    /**
     * 添加歌曲
     *
     * @param addSongDTO
     */
    @Override
    public void addSong(AddSongDTO addSongDTO) {
        if(addSongDTO.getName()==null||addSongDTO.getSingerId()==0||addSongDTO.getName()==""){
           throw new CustomException(Constant.FAILCODE,Constant.PARAMETERFAIL);
        }
        int isAdd = songMapper.addSong(addSongDTO);
        if(isAdd<1){
            throw new CustomException(Constant.FAILCODE,Constant.ADDFAIL);
        }

    }

    /**
     * 查询全部歌曲(分页)
     *
     * @param page
     * @param size
     * @return PageBean
     */
    @Override
    public PageBean selectAllSong(Integer page, Integer size) {
        getPageCountResult getPageCountResult=new getPageCountResult(page,size);
        List<SongVO> songs = songMapper.Songlist(getPageCountResult.getStartIndex(), getPageCountResult.getSize());
        PageBean pageBean=new PageBean(songMapper.SelectSongCount(),songs);
        return pageBean;
    }

    /**
     * 依据歌手id查歌曲
     *
     * @param singerId
     * @return
     */
    @Override
    public PageBean seletcListById(Integer singerId,Integer page,Integer size) {
        getPageCountResult getPageCountResult=new getPageCountResult(page,size);
        List<SongVO> songs = songMapper.SongListById(singerId,getPageCountResult.getStartIndex(), getPageCountResult.getSize());
        PageBean pageBean=new PageBean(songMapper.SelectSongCountById(singerId),songs);
        return pageBean;
    }

    /**删除歌曲
     * @param songId
     */
    @Override
    public void deleteSong(Integer songId) {
        int isDelete=songMapper.deleteSongById(songId);
        if(isDelete<1){
            throw new CustomException(Constant.FAILCODE, Constant.DELETEFAIL);
        }
    }

    /**
     * 修改歌曲信息
     *
     * @param songDTO
     */
    @Override
    public void updateSong(SongDTO songDTO) {
        int isupdate=songMapper.updateSong(songDTO);
        if(isupdate<1){
            throw new CustomException(Constant.FAILCODE,Constant.UPDATEFAIL);
        }
    }


}
