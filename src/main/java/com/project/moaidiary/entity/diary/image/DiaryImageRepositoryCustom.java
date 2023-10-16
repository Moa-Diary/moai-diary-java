package com.project.moaidiary.entity.diary.image;

import java.util.List;

public interface DiaryImageRepositoryCustom {
    List<DiaryImage> findAllByDiaryId(Long diaryId);
}
