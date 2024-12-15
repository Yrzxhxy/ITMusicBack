package com.javaclimb.itmusic.controller.User;

import com.javaclimb.itmusic.pojo.PageBean;
import com.javaclimb.itmusic.pojo.vo.ListSongVO;
import com.javaclimb.itmusic.pojo.vo.SongListVO;
import com.javaclimb.itmusic.service.UserSongListService;
import com.javaclimb.itmusic.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "歌单相关接口")
@RequestMapping("/user")
public class UserSongListController {

    @Autowired
   private UserSongListService userSongListService;

    @GetMapping("/getSongList")
    @ApiOperation("获取歌单列表(分页)")
    public ResponseResult getSongList(@Param("page") Integer page,@Param("size")Integer size){
        PageBean pageBean =userSongListService.getSongList(page,size);
        return ResponseResult.success(pageBean);
    }

    @GetMapping("/getListSong/{SongListId}")
    @ApiOperation("获取歌单内歌曲列表")
    public ResponseResult getListSong(@PathVariable("SongListId") Integer SongListId){
        ListSongVO songFromList = userSongListService.getSongFromList(SongListId);
        return ResponseResult.success(songFromList);
    }
}
