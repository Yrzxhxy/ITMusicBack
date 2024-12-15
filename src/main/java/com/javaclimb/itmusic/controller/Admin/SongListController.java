package com.javaclimb.itmusic.controller.Admin;

import com.javaclimb.itmusic.common.Constant;
import com.javaclimb.itmusic.pojo.domain.SongList;
import com.javaclimb.itmusic.pojo.dto.SongListDTO;
import com.javaclimb.itmusic.pojo.vo.ListSongVO;
import com.javaclimb.itmusic.pojo.vo.SongListVO;
import com.javaclimb.itmusic.service.SongListService;
import com.javaclimb.itmusic.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 歌单
 */
@Api(tags="歌单相关接口")
@RestController
@Slf4j
@RequestMapping("admin/songList")
public class SongListController {

    @Autowired
    private SongListService songListService;

    /**
     * 创建歌单
     * @return
     */
    @ApiOperation("创建歌单")
    @PostMapping("/createSongList")
    public ResponseResult createSongList(SongListDTO songListDTO){
        songListService.createSongList(songListDTO);
        return ResponseResult.success(Constant.ADDSUCCESS);
    }

    @ApiOperation("添加歌曲至歌单")
    @PostMapping("addSongToList")
    public ResponseResult addSongToList(@Param("songId") Integer songId,@Param("listId") Integer listId){
        songListService.addSongToList(songId,listId);
        return ResponseResult.success(Constant.ADDSUCCESS);
    }

    @ApiOperation("查询歌单列表")
    @GetMapping("/getSongList")
    public ResponseResult getSongList(){
        List<SongListVO>  songListVO =songListService.getSongList();
        return ResponseResult.success(songListVO);
    }

    @ApiOperation("查询歌单中歌曲列表")
    @GetMapping("/getSongFromList/{songListId}")
    public  ResponseResult getSongFromList(@PathVariable("songListId") Integer songListId ){
        ListSongVO listSongVO=songListService.getSongFromList(songListId);
        return ResponseResult.success(listSongVO);
    }

    @ApiOperation("修改歌单信息")
    @PutMapping("confirmSongList")
    public ResponseResult confirmSongList(@RequestBody SongList songList){
        songListService.updateSongList(songList);
        return ResponseResult.success(Constant.CONFIRMSUCCESS);

    }

    @ApiOperation("删除歌单")
    @DeleteMapping("/deleteSongList/{songListId}")
    public ResponseResult deleteSongList(@PathVariable("songListId") Integer songListId ){
        songListService.deleteSongList(songListId);
        return ResponseResult.success(Constant.DELETESUCCESS);
    }
}
