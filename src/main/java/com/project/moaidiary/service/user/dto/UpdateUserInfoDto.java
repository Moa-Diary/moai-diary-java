package com.project.moaidiary.service.user.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UpdateUserInfoDto {
    @NotEmpty
    private String userDisplayName;
    private String userPhone;
    @NotEmpty
    private String imageProfileName;
}
