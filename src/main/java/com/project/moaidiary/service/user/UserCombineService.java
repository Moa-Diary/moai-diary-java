package com.project.moaidiary.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCombineService {
    private final UserService userService;
}
