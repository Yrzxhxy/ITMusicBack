package com.javaclimb.itmusic.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.javaclimb.itmusic.common.Constant;
import com.javaclimb.itmusic.dao.CollectionMapper;
import com.javaclimb.itmusic.exception.CustomException;
import com.javaclimb.itmusic.pojo.vo.SongListVO;
import com.javaclimb.itmusic.pojo.vo.SongVO;
import com.javaclimb.itmusic.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionMapper collectionMapper;

    /**
     * 添加歌曲至收藏列表
     * @param userId
     * @param songId
     */
    @Override
    public void addSongTO(Integer userId, Integer songId) {
        if(userId==null||songId==null){throw new CustomException(Constant.FAILCODE,Constant.PARAMETERFAIL);}
        if(collectionMapper.isSongExist(userId,songId)<1){
            Integer type=0;
            int isAdd =collectionMapper.addSongTo(userId,songId,type);
            if(isAdd<1){throw  new CustomException(Constant.FAILCODE,Constant.ADDFAIL);}
        }else{
          throw  new CustomException(Constant.FAILCODE,Constant.EXIST);
        }


    }

    /**
     * 添加歌单到收藏列表
     * @param userId
     * @param songListId
     */
    @Override
    public void addSongListTO(Integer userId, Integer songListId) {
        if(userId==null||songListId==null){throw new CustomException(Constant.FAILCODE,Constant.PARAMETERFAIL);}
        if(collectionMapper.isSongListExist(userId,songListId)<1){
            Integer type=1;
            int isAdd =collectionMapper.addSongListTo(userId,songListId,type);
            if(isAdd<1){throw  new CustomException(Constant.FAILCODE,Constant.ADDFAIL);}
        }else{
            throw  new CustomException(Constant.FAILCODE,Constant.EXIST);
        }
    }

    /**
     * 获取收藏列表
     * @param type
     * @param userId
     */
    @Override
    public List<?> getCollect(Integer type, Integer userId) {
        if(type==null||userId==null){throw new CustomException(Constant.FAILCODE,Constant.PARAMETERFAIL);}
//        List<?> songsCollect=collectionMapper.getCollect(userId,type);
//        if(songsCollect==null){throw new CustomException(Constant.FAILCODE,Constant.NORECORD);}
//        if(type==0){
//            List<SongVO> collect = songsCollect.stream().map(s -> {
//                        SongVO songVO = new SongVO();
//                        BeanUtil.copyProperties(s, songVO);
//                        return songVO;
//                    }
//            ).collect(Collectors.toList());
//            return collect;
//        }else{
//            List<SongListVO> collect = songsCollect.stream().map(s -> {
//                        SongListVO songListVO=new SongListVO();
//                        BeanUtil.copyProperties(s, songListVO);
//                        return songListVO;
//                    }
//            ).collect(Collectors.toList());
//            return collect;
//        }
        return null;

    }

}
