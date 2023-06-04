package com.project.moaidiary.controller;

import com.project.moaidiary.service.user.UserCombineService;
import com.project.moaidiary.service.user.UserService;
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

}
