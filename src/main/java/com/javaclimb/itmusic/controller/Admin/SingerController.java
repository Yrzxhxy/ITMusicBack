package com.javaclimb.itmusic.controller.Admin;

import com.javaclimb.itmusic.common.Constant;
import com.javaclimb.itmusic.pojo.PageBean;
import com.javaclimb.itmusic.pojo.dto.AddSingerDTO;
import com.javaclimb.itmusic.pojo.dto.SingerDTO;
import com.javaclimb.itmusic.pojo.vo.SingerVO;
import com.javaclimb.itmusic.service.SingerService;
import com.javaclimb.itmusic.utils.ResponseResult;
import com.javaclimb.itmusic.utils.enums.HttpCodeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@Api(tags = "歌手相关接口")
@RequestMapping("/admin/singer")
public class SingerController {
    @Autowired
    private SingerService singerService;


    @ApiOperation("添加歌手")
    @PostMapping ("/addSinger")
    public ResponseResult addSinger(@RequestBody AddSingerDTO addSingerDTO){
        boolean isAdd = singerService.add(addSingerDTO);
        if(isAdd){
            return ResponseResult.success(1,Constant.ADDSUCCESS);
        }
        return ResponseResult.fail(HttpCodeEnum.RC401);
    }

    @ApiOperation("查询歌手详情")
    @GetMapping("/getSinger/{id}")
    public ResponseResult slecteSinger(@PathVariable("id") int id){
        SingerVO singerVO = singerService.selectSinger(id);

        if(singerVO==null){
            return ResponseResult.fail(Constant.FAILCODE,Constant.SELECTEFAIL);
        }

        return ResponseResult.success(Constant.SELECTESUCCESS,singerVO);
    }

    @ApiOperation("修改歌手信息")
    @PutMapping("/confirmSinger")
    public ResponseResult confirmSinger(@RequestBody SingerDTO singerDTO){
        boolean b = singerService.confirmSinger(singerDTO);

            return ResponseResult.success(Constant.CONFIRMSUCCESS);

    }

    /**
     *
     * @param ids
     * @return
     */
    @ApiOperation("删除歌手(可批量)")
    @DeleteMapping("/delSinger/")
    public  ResponseResult deleteSinger(@RequestParam List<Integer> ids){
        singerService.deletedSinger(ids);

       return ResponseResult.success(Constant.DELETESUCCESS);
    }
    @ApiOperation("获取歌手列表(分页查询)")
    @GetMapping("/getSingerList")
    public ResponseResult getSingerList(@Param("page") Integer page,@Param("size") Integer size){
        PageBean pageBean = singerService.selectPage(page,size);

        return ResponseResult.success(Constant.SELECTESUCCESS,pageBean);
    }
}
