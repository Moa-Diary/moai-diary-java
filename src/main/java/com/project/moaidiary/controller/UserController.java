package com.project.moaidiary.controller;

import com.project.moaidiary.service.user.UserCombineService;
import com.project.moaidiary.service.user.UserService;
import com.project.moaidiary.service.user.dto.CreateUserDto;
import com.project.moaidiary.service.user.dto.UpdateUserInfoDto;
import com.project.moaidiary.service.user.dto.UserInfoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // 회원 정보 업데이트
    @PutMapping("/{userEmail}")
    public void updateUserInfo(@PathVariable String userEmail, @RequestBody UpdateUserInfoDto updateUserInfoDto){
        userCombineService.updateUserInfo(userEmail, updateUserInfoDto);
    }

    // 회원 탈퇴(삭제)
    @DeleteMapping("/{userEmail}")
    public void deleteUser(@PathVariable String userEmail) {
        userCombineService.deleteUser(userEmail);
    }
    
    //이메일 중복 체크
    @GetMapping("/check/email/{userEmail}")
    public Boolean checkExistUserEmail(@PathVariable String userEmail){
        return userService.isExistUserEmail(userEmail);
    }

    @GetMapping("/internal-api/all")
    public List<UserInfoDto> getAllUserInfo() {
        return userCombineService.getAllUserInfo();
    }
}
