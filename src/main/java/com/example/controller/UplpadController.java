package com.example.controller;

import com.example.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UplpadController {
  @PostMapping("/upload")
  public Result upload(String name, Integer age, MultipartFile file) throws IOException {
    log.info("接收到的参数:{}, {}, {}", name, age, file);
    String originalFilename = file.getOriginalFilename();
    String uuid = UUID.randomUUID().toString();
    String newFileName = uuid + "_" + originalFilename;
    file.transferTo(new File("C:/Users/txj/Desktop/Curriculum/" + newFileName));
    return Result.success();
  }
}
