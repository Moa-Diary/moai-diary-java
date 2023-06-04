package com.project.moaidiary.service.user.dto;

import com.project.moaidiary.entity.user.User;
import com.project.moaidiary.moai_enum.ImageProfile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UserInfoDto {
    private String userDisplayName;
    private String userName;
    private String userEmail;
    private ImageProfile imageProfileName;

    public static UserInfoDto from(User user){
        return UserInfoDto.builder()
            .userDisplayName(user.getUserDisplayName())
            .userName(user.getUserName())
            .userEmail(user.getUserEmail())
            .imageProfileName(user.getImageProfileName())
            .build();
    }
}
