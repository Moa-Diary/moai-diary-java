package com.project.moaidiary.service.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {
    private String userName;
    private String userEmail;
    private String firebaseUniqueKey;
}
