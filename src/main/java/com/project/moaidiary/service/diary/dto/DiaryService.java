package com.project.moaidiary.service.diary.dto;

import com.project.moaidiary.entity.diary.Diary;
import com.project.moaidiary.entity.diary.DiaryRepository;
import com.project.moaidiary.exception.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.project.moaidiary.exception.CustomErrorCode.NOT_EXIST_DIARY;

@Service
@Slf4j
@RequiredArgsConstructor
public class DiaryService {
    private final DiaryRepository diaryRepository;

    public Long getDiaryCountByUserId(Long userId) {
        return diaryRepository.diaryCountByUserId(userId);
    }

    public void modifyDiaryIsPublic(Long diaryId, Boolean isPublic) {
        Diary diary = diaryRepository.findById(diaryId).orElseThrow(() -> new CustomException(NOT_EXIST_DIARY));
        diary.modifyIsPublic(isPublic);
        diaryRepository.save(diary);
    }

    public void modifyDiaryIsCommentAvailable(Long diaryId, Boolean isAvailableComment) {
        Diary diary = diaryRepository.findById(diaryId).orElseThrow(() -> new CustomException(NOT_EXIST_DIARY));
        diary.modifyIsAvailableComment(isAvailableComment);
        diaryRepository.save(diary);
    }
}
