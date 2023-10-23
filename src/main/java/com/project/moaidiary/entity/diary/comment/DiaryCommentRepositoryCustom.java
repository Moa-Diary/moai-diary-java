package com.project.moaidiary.entity.diary.comment;

import com.project.moaidiary.service.diary.comment.vo.DiaryCommentDetailVo;

import java.util.List;

public interface DiaryCommentRepositoryCustom {
    List<DiaryCommentDetailVo> findDiaryCommentWithLikeCountByDiaryId(Long diaryId);
}
