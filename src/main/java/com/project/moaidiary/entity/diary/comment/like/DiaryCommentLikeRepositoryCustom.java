package com.project.moaidiary.entity.diary.comment.like;

import java.util.Optional;

public interface DiaryCommentLikeRepositoryCustom {
    Optional<DiaryCommentLike> findByDiaryCommentIdAndUserId(Long commentId, Long userId);
}
