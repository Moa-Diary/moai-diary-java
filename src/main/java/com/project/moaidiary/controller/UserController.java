package com.project.moaidiary.controller;

import com.project.moaidiary.service.user.UserCombineService;
import com.project.moaidiary.service.user.UserService;
import com.project.moaidiary.service.user.dto.CreateUserDto;
import com.project.moaidiary.service.user.dto.UserInfoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserCombineService userCombineService;
    private final UserService userService;
    
    // 회원가입
    @PostMapping("/create")
    public void createUser(@RequestBody CreateUserDto createUserDto){
        userService.createUser(createUserDto);
    }

    // 회원 정보 조회
    @GetMapping("/{userEmail}")
    public UserInfoDto getUserInfo(@PathVariable String userEmail) {
        return userCombineService.getUserInfoByUserEmail(userEmail);
    }
}
