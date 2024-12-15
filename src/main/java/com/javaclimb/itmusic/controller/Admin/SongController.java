package com.javaclimb.itmusic.controller.Admin;

import com.javaclimb.itmusic.common.Constant;
import com.javaclimb.itmusic.pojo.PageBean;
import com.javaclimb.itmusic.pojo.dto.AddSongDTO;
import com.javaclimb.itmusic.pojo.dto.SongDTO;
import com.javaclimb.itmusic.service.SongService;
import com.javaclimb.itmusic.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@Api(tags = "歌曲相关接口")
@RequestMapping("/admin/song")
public class SongController {

    @Resource
    private SongService songService;

    @ApiOperation("添加歌曲")
    @PostMapping("/addSong")
    public ResponseResult addSong(@RequestBody AddSongDTO addSongDTO){
        songService.addSong(addSongDTO);
        return ResponseResult.success(Constant.ADDSUCCESS);
    }

    @ApiOperation("查询全部歌曲(分页)")
    @GetMapping("/getSongList")
    public ResponseResult getSongList(@Param("page") Integer page, @Param("size") Integer size){
        PageBean pageBean=songService.selectAllSong(page, size);

        return ResponseResult.success(Constant.SELECTESUCCESS,pageBean);
    }
//    依据歌手id查歌曲

    @ApiOperation("依据歌手id查所属歌曲(分页)")
    @GetMapping("/getSongListById")
    public ResponseResult getSongListById(@Param("singerId") Integer singerId,@Param("page") Integer page,@Param("size") Integer size ){
        PageBean pageBean=songService.seletcListById(singerId,page,size);
        return ResponseResult.success(Constant.SELECTESUCCESS,pageBean);
    }

    /**
     * 删除歌曲
     * @param songId
     * @return
     */
    @ApiOperation("删除歌曲")
    @DeleteMapping("/deleteSong/{songId}")
    public ResponseResult deleteSong(@PathVariable("songId") Integer songId){
        songService.deleteSong(songId);
        return ResponseResult.success(Constant.DELETESUCCESS);
    }

    /**
     * 修改歌曲信息
     * @param songDTO
     * @return
     */
    @ApiOperation("修改歌曲信息")
    @PutMapping("/updateSong")
    public ResponseResult updateSong(@RequestBody SongDTO songDTO){
        songService.updateSong(songDTO);
        return ResponseResult.success(Constant.CONFIRMSUCCESS);
    }
}
