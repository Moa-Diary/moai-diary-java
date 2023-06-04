package com.project.moaidiary.controller;

import com.project.moaidiary.service.user.UserCombineService;
import com.project.moaidiary.service.user.UserService;
import com.project.moaidiary.service.user.dto.CreateUserDto;
import com.project.moaidiary.service.user.dto.UpdateUserInfoDto;
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
    @PostMapping("/create")
    public void createUser(@RequestBody CreateUserDto createUserDto){
        userService.createUser(createUserDto);
    }

    @GetMapping("/{userEmail}")
    public UserInfoDto getUserInfo(@PathVariable String userEmail) {
        return userCombineService.getUserInfoByUserEmail(userEmail);
    }

    @PutMapping("/{userEmail}")
    public void updateUserInfo(@PathVariable String userEmail, @RequestBody UpdateUserInfoDto updateUserInfoDto){
        userCombineService.updateUserInfo(userEmail, updateUserInfoDto);
    }
    @GetMapping("/check/email/{userEmail}")
    public Boolean checkExistUserEmail(@PathVariable String userEmail){
        return userService.isExistUserEmail(userEmail);
    }
}
