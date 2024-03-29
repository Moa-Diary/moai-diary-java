package com.project.moaidiary.service.user.dto;

import com.project.moaidiary.entity.user.User;
import com.project.moaidiary.moai_enum.ImageProfile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto {
    private Long userId;
    private String userDisplayName;
    private String userName;
    private String userEmail;
    private String userPhone;
    private ImageProfile imageProfileName;

    public static List<UserInfoDto> from(List<User> userList) {
        return userList.stream().map(UserInfoDto::from).collect(Collectors.toList());
    }

    public static UserInfoDto from(User user){
        return UserInfoDto.builder()
            .userId(user.getUserId())
            .userDisplayName(user.getUserDisplayName())
            .userName(user.getUserName())
            .userEmail(user.getUserEmail())
            .userPhone(user.getUserPhone())
            .imageProfileName(user.getImageProfileName())
            .build();
    }
}
