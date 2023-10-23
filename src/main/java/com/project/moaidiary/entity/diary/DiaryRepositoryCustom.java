package com.project.moaidiary.entity.diary;

import com.project.moaidiary.service.diary.vo.DiaryDetailVo;

import java.util.Optional;

public interface DiaryRepositoryCustom {
    Long diaryCountByUserId(Long userId);
    Optional<DiaryDetailVo> findDiaryDetailByDiaryId(Long diaryId);
}
