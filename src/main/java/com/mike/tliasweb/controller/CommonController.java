package com.mike.tliasweb.controller;

import com.mike.tliasweb.entity.Result;
import com.mike.tliasweb.utils.AliOSSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author: mikeshinoda
 * @date: 2024/1/9
 * @description:
 */
@RestController
public class CommonController {

    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping("/upload")
    public Result upload(MultipartFile image) {
        try {
            String url = aliOSSUtils.upload(image);
            return Result.success(url);

        } catch (IOException e) {
            System.out.println(e);
        }
        return Result.error("上传失败");

    }
}
