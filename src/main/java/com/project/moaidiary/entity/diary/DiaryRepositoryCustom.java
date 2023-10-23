package com.project.moaidiary.entity.diary;

import com.project.moaidiary.service.diary.vo.DiaryDetailVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface DiaryRepositoryCustom {
    Long diaryCountByUserId(Long userId);
    Optional<DiaryDetailVo> findDiaryDetailByDiaryId(Long diaryId);
    Page<DiaryDetailVo> findAllDiaryDetailByUserId(Long userId, Pageable pageable);
}
