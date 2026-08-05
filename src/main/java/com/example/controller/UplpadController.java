package com.example.controller;

import com.example.pojo.Result;
import com.example.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@Slf4j
@RestController
public class UplpadController {
  @Autowired
  private AliyunOSSOperator aliyunOSSOperator;

  // 本地磁盘存储
  // @PostMapping("/upload")
  // public Result upload(String name, Integer age, MultipartFile file) throws IOException {
  //   log.info("接收到的参数:{}, {}, {}", name, age, file);
  //   String originalFilename = file.getOriginalFilename();
  //   String uuid = UUID.randomUUID().toString();
  //   String newFileName = uuid + "_" + originalFilename;
  //   file.transferTo(new File("C:/Users/txj/Desktop/Curriculum/" + newFileName));
  //   return Result.success();
  // }

  @PostMapping("/upload")
  public Result upload(MultipartFile file) {
    try {
      log.info("接收到的参数:{}", file.getOriginalFilename());
      // 将文件交给oss存储
      String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
      log.info("上传成功, url:{}", url);
      return Result.success(url);
    } catch (Exception e) {
      log.error("文件上传失败", e);
      return Result.error("上传失败：" + e.getMessage());
    }
  }
}
