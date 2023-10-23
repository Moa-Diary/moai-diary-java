package com.project.moaidiary.service.diary.dto;

import com.project.moaidiary.service.diary.comment.dto.DiaryCommentDetailDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiaryDetailDto {
    private Long diaryId;
    private String userDisplayName;
    private String userProfileImage;
    private String title;
    private String content;
    private Long likeCount;
    private int commentCount;
    private List<String> hashTags;
    private String emotion;
    private Long createdAt;
    private Boolean isPublic;
    private Boolean isAvailableComment;
    private List<String> imageUrls;
    private List<DiaryCommentDetailDto> comment;
}
