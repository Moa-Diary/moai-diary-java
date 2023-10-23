package com.project.moaidiary.service.diary.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiaryCommentDetailDto {
    private String commentBy;
    private String commentByImage;
    private String comment;
    private Long commentId;
    private Long commentLikeCount;
}
