package com.javaclimb.itmusic.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.javaclimb.itmusic.common.Constant;
import com.javaclimb.itmusic.dao.SingerMapper;
import com.javaclimb.itmusic.exception.CustomException;
import com.javaclimb.itmusic.pojo.PageBean;
import com.javaclimb.itmusic.pojo.domain.Singer;
import com.javaclimb.itmusic.pojo.dto.AddSingerDTO;
import com.javaclimb.itmusic.pojo.dto.SingerDTO;
import com.javaclimb.itmusic.pojo.vo.SingerVO;
import com.javaclimb.itmusic.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingerServiceImpl implements SingerService {

    @Autowired
    private SingerMapper singerMapper;

    /**
     * @param addSignerDTO
     * @return
     */
    @Override
    public boolean add(AddSingerDTO addSignerDTO) {
        if(addSignerDTO.getName()==null||addSignerDTO.getName()==""){
            return false;
        }
//        Singer singer =new Singer();
//        BeanUtil.copyProperties(addSignerDTO, singer);
        int insert = singerMapper.insert(addSignerDTO);

        return insert>0;
    }

    /**
     * 删除歌手(可批量)
     *
     * @param ids
     * @return
     */
    @Override
    public void deletedSinger(List<Integer> ids) {
        singerMapper.delete(ids);
    }

    /**
     * 查询歌手详情
     *
     * @param id
     * @return
     */
    @Override
    public SingerVO selectSinger(int id) {
        Singer selecte = singerMapper.selecte(id);
        if(selecte==null){
           throw new CustomException(Constant.FAILCODE, Constant.PARAMETERFAIL);
        }
        SingerVO singer=new SingerVO();
        BeanUtil.copyProperties(selecte,singer);
        return singer;
    }

    /**
     * 修改歌手信息
     * @param singerDTO
     * @return
     */
    @Override
    public boolean confirmSinger(SingerDTO singerDTO) {
        if(singerDTO.getId()!=0){
            Singer singer =new Singer();
            BeanUtil.copyProperties(singerDTO, singer);
            singerMapper.update(singer);
            return true;
        }

        throw new CustomException(Constant.FAILCODE,Constant.UPDATEFAIL);

    }

    /**
     * @param page 页码
     * @param size 总记录数
     * @return 每页数据
     */
    @Override
    public PageBean selectPage(Integer page, Integer size) {
        int startIndex;
        Long total;
        if(page==null){
            page=1;
        }
        if(size==null){
            size=10;
        }

//        计算起始索引
        startIndex=(page-1)*size;
//        总记录数
        total = singerMapper.selectCounts();
        List<SingerVO> signers = singerMapper.selectPage(startIndex, size);
        PageBean pageBean=new PageBean(total,signers);
        return pageBean;
    }


}
