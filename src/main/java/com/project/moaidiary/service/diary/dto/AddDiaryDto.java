package com.project.moaidiary.service.diary.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddDiaryDto {
    private String title;
    private String content;
    private String hashTag;
    private String emotion;
    private boolean isPublic;
    private boolean isAvailableComment;
}
