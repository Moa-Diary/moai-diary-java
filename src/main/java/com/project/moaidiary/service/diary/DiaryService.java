package com.project.moaidiary.service.diary;

import com.project.moaidiary.entity.diary.Diary;
import com.project.moaidiary.entity.diary.DiaryRepository;
import com.project.moaidiary.exception.CustomException;
import com.project.moaidiary.service.diary.dto.DiaryDetailDto;
import com.project.moaidiary.service.diary.vo.DiaryDetailVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.project.moaidiary.exception.CustomErrorCode.NOT_EXIST_DIARY;
import static com.project.moaidiary.exception.CustomErrorCode.NOT_EXIST_DIARY_COMMENT;

@Service
@Slf4j
@RequiredArgsConstructor
public class DiaryService {
    private final DiaryRepository diaryRepository;

    public Diary getDiaryByDiaryId(Long diaryId) {
        return diaryRepository.findById(diaryId).orElseThrow(() -> new CustomException(NOT_EXIST_DIARY));
    }

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

    public void deleteById(Long diaryId) {
        diaryRepository.deleteById(diaryId);
    }

    public void putDiary(Diary diary) {
        diaryRepository.save(diary);
    }

    public DiaryDetailVo getDiaryDetailByDiaryId(Long diaryId){
        return diaryRepository.findDiaryDetailByDiaryId(diaryId).orElseThrow(() -> new CustomException(NOT_EXIST_DIARY_COMMENT));
    }

    public Page<DiaryDetailVo> getDiaryDetailByUserId(Long userId, Pageable pageable) {
        return diaryRepository.findAllDiaryDetailByUserId(userId, pageable);
    }

    public Page<DiaryDetailVo> getDiaryDetail(Pageable pageable) {
        return diaryRepository.findAllDiaryDetail(pageable);
    }

    public void addDiary(Diary diary) {
        diaryRepository.save(diary);
    }
}
