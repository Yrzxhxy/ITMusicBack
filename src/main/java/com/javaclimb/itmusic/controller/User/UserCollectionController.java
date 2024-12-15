package com.javaclimb.itmusic.controller.User;

import com.javaclimb.itmusic.common.Constant;
import com.javaclimb.itmusic.service.CollectionService;
import com.javaclimb.itmusic.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(tags = "收藏相关接口")
public class UserCollectionController {

    @Resource
    private CollectionService collectionService;

    @PostMapping("addSongToCollection/")
    @ApiOperation("添加歌曲到收藏")
    public ResponseResult addSongToCollection(@Param(value = "userId")Integer userId,@Param("songId")Integer songId){
        collectionService.addSongTO(userId,songId);
        return ResponseResult.success(Constant.ADDSUCCESS);
    }

    @PostMapping("addSongListToCollection/")
    @ApiOperation("添加歌单到收藏")
    public ResponseResult addSongListToCollection(@Param(value = "userId")Integer userId,@Param("songListId")Integer songListId){
        collectionService.addSongListTO(userId,songListId);
        return ResponseResult.success(Constant.ADDSUCCESS);
    }

    @GetMapping("getCollection")
    @ApiOperation("获取用户收藏列表")
    public ResponseResult getCollection(@Param("type")Integer type,@Param("userId")Integer userId){
        List<?> collect = collectionService.getCollect(type, userId);
        return ResponseResult.success(collect);
    }
}
