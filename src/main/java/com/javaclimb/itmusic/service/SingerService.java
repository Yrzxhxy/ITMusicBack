package com.javaclimb.itmusic.service;

import com.javaclimb.itmusic.pojo.PageBean;
import com.javaclimb.itmusic.pojo.dto.AddSingerDTO;
import com.javaclimb.itmusic.pojo.dto.SingerDTO;
import com.javaclimb.itmusic.pojo.vo.SingerVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 歌手service
 * 2024-10-28
 * hxy
 */
public interface SingerService {

    /**
     * 添加歌手
     * @param addSingerDTO
     * @return
     */
    boolean add(AddSingerDTO addSingerDTO);


    /**
     * 删除歌手
     * @param ids
     * @return
     */
    void deletedSinger(@Param("ids")List<Integer> ids);


    /**
     * 查询歌手详情
     * @param id
     * @return
     */
    SingerVO selectSinger(int id);


    /**
     * 修改歌手信息
     * @param singerDTO
     * @return
     */
    boolean confirmSinger(SingerDTO singerDTO);

    /**
     *
     * @param page
     * @param size
     * @return
     */
    PageBean selectPage(Integer page, Integer size);
}
