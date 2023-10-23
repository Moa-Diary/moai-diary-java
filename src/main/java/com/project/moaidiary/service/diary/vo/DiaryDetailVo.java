package com.project.moaidiary.service.diary.vo;

import com.project.moaidiary.moai_enum.ImageProfile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiaryDetailVo {
    private Long diaryId;
    private String userDisplayName;
    private ImageProfile imageProfileName;
    private String title;
    private String content;
    private String hashTag;
    private String emotion;
    private Date createdAt;
    private Boolean isPublic;
    private Boolean isAvailableComment;
}
