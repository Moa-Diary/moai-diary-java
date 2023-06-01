package com.project.moaidiary.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HelloController {
    @GetMapping("/health/check")
    public HttpStatus healthCheck(){
        return HttpStatus.OK;
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello, this is moai diary";
    }
}
