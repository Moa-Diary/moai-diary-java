package com.project.moaidiary.service.diary.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiaryCombineService {
    private final DiaryService diaryService;

    public DiaryCountDto countDiaryByUserEmail(Long userId) {
        Long diaryCount = diaryService.getDiaryCountByUserId(userId);
        return DiaryCountDto.builder()
            .count(diaryCount)
            .build();
    }
}