package com.javaclimb.itmusic.controller.Common;

import com.javaclimb.itmusic.common.Constant;
import com.javaclimb.itmusic.common.RandomID;
import com.javaclimb.itmusic.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@Api(tags = "文件相关接口")
public class UploadController {

    @ApiOperation("上传")
    @PostMapping("/upload")
    public ResponseResult handleFileUpload(@RequestPart("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseResult.fail("文件为空");
        }
        try {
//            文件路径
            File dir = new File(Constant.FILEURL);
            if (!dir.exists()) {
                dir.mkdirs(); // 如果目录不存在，则创建目录
            }
//            利用uuid生成文件名
            String fileName = new RandomID().generateRandomFileName(file.getOriginalFilename());
            File uploadedFile = new File(Constant.FILEURL + fileName);
            file.transferTo(uploadedFile);
            Map<String, Object> fileInfo = new HashMap<>();
            fileInfo.put("size", file.getSize());
            fileInfo.put("url", "http://localhost:8888/file/upload/" + fileName);
            return ResponseResult.success(Constant.UPLOADSUCCESS, fileInfo);
        } catch (IOException ex) {
            return ResponseResult.fail(ex.getMessage());

        }


    }

    @ApiOperation("下载")
    @GetMapping("/file/upload/{filename}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("filename") String filename) {
        try {
//            规范路径
            Path file = Paths.get(Constant.FILEURL + filename).normalize();
            Resource resource = new UrlResource(file.toUri());
//            判断文件是否存在或可访问
            if (resource.exists() || resource.isReadable()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType("application/octet-stream"))
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

    }

    /**
     * 处理文件异常
     * @param e
     * @return
     */
    @ExceptionHandler(MissingServletRequestPartException.class)
    public ResponseResult handleMissingServletRequestPartException(MissingServletRequestPartException e) {
        log.error("MissingServletRequestPartException: ", e);
        return ResponseResult.fail("文件为空");
    }

}
