package com.javaclimb.itmusic.service;


import com.javaclimb.itmusic.pojo.vo.SearchResultVO;

public interface SearchService {

    /**
     * 模糊查询（歌手名，歌曲名）
     * @param keyWords
     * @return
     */
    SearchResultVO obscureSearch(String keyWords);
}
