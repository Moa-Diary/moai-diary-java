package com.project.moaidiary.service.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {
    @NotBlank(message = "사용자명은 필수값 입니다.")
    private String userName;
    @NotBlank(message = "이메일은 필수값입니다.")
    private String userEmail;
    private String firebaseUniqueKey;
}
