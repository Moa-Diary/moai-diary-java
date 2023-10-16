package com.project.moaidiary.entity.diary.like;

import java.util.Optional;

public interface DiaryLikeRepositoryCustom {
    Optional<DiaryLike> findDiaryLikeByDiaryIdAndUserId(Long diaryId, Long userId);
}
