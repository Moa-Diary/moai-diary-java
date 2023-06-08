package com.project.moaidiary.service.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserInfoDto {
    @NotEmpty
    private String userDisplayName;
    private String userPhone;
    @NotEmpty
    private String imageProfileName;
}
