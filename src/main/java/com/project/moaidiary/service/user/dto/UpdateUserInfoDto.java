package com.project.moaidiary.service.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserInfoDto {
    @NotBlank(message = "별칭은 필수 입력값입니다.")
    private String userDisplayName;
    private String userPhone;
    private String imageProfileName;
}
