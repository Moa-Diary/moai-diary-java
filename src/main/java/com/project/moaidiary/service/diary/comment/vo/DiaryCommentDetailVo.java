package com.project.moaidiary.service.diary.comment.vo;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiaryCommentDetailVo {
    private Long commentId;
    private String comment;
    private String commentBy;
}
