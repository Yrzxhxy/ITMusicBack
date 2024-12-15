package com.javaclimb.itmusic.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.javaclimb.itmusic.dao.SearchMapper;
import com.javaclimb.itmusic.pojo.vo.SearchResultVO;
import com.javaclimb.itmusic.pojo.vo.SingerVO;
import com.javaclimb.itmusic.pojo.vo.SongVO;
import com.javaclimb.itmusic.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchMapper searchMapper;

    /**
     * 模糊查询（歌手名，歌曲名）
     *
     * @param keywords
     * @return
     */
    @Override
    public SearchResultVO obscureSearch(String keywords) {
        //查询歌手
       List<SingerVO> singers =searchMapper.searchSinger(keywords);
        //查询歌曲
       List<SongVO> songs= searchMapper.searchSongs(keywords);

       SearchResultVO searchResultVO=new SearchResultVO(singers,songs);

        return searchResultVO;
    }
}
