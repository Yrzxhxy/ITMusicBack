package com.javaclimb.itmusic.dao;

import com.javaclimb.itmusic.pojo.domain.Singer;
import com.javaclimb.itmusic.pojo.dto.AddSingerDTO;
import com.javaclimb.itmusic.pojo.vo.SingerVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SingerMapper {

    /**
     * 增加歌手
     * @param addSingerDTO
     * @return
     */
    int insert(AddSingerDTO addSingerDTO);

    /**
     * 更新歌手信息
     * @param singer
     * @return
     */
    int update(Singer singer);

    /**
     * 删除歌手信息
     * @param ids
     * @return
     */
    void delete(@Param("ids") List<Integer> ids);

    /**
     * 查询歌手信息
     * @param id
     * @return
     */
    Singer selecte(int id);


    /**
     *
     * @param startIndex 起始索引
     * @param page 页数
     * @return singer集合
     */
    List<SingerVO> selectPage(@Param("startIndex") Integer startIndex, @Param("page") Integer page);

    @Select("select count(*) from singer")
    Long selectCounts();
}
