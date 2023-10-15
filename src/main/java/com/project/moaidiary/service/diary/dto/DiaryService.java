package com.project.moaidiary.service.diary.dto;

import com.project.moaidiary.entity.diary.DiaryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DiaryService {
    private final DiaryRepository diaryRepository;

    public Long getDiaryCountByUserId(Long userId) {
        return diaryRepository.diaryCountByUserId(userId);
    }
}
