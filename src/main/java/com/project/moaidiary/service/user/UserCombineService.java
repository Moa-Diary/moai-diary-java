package com.project.moaidiary.service.user;

import com.project.moaidiary.entity.user.User;
import com.project.moaidiary.service.user.dto.UserInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCombineService {
    private final UserService userService;

    public UserInfoDto getUserInfoByUserEmail(String userEmail){
        User user = userService.getUserByUserEmail(userEmail);
        return UserInfoDto.from(user);
    }
}
