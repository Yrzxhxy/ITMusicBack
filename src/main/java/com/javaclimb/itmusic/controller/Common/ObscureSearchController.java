package com.javaclimb.itmusic.controller.Common;

import com.javaclimb.itmusic.pojo.vo.SearchResultVO;
import com.javaclimb.itmusic.pojo.vo.SingerVO;
import com.javaclimb.itmusic.pojo.vo.SongVO;
import com.javaclimb.itmusic.service.SearchService;
import com.javaclimb.itmusic.service.SingerService;
import com.javaclimb.itmusic.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "搜索相关")
public class ObscureSearchController {

    @Autowired
    private SearchService searchService;

    /**
     * 模糊搜索（歌曲名或歌手名）
     */

    @GetMapping("/obscureSearch")
    @ApiOperation(" 模糊搜索（歌曲名或歌手名）")
    public ResponseResult obscureSearch(@Param("keyWords") String keyWords ){
        SearchResultVO searchResultVO =searchService.obscureSearch(keyWords);
        return ResponseResult.success(searchResultVO);
    }

}
