package com.project.moaidiary.service.diary.like;

import com.project.moaidiary.entity.diary.like.DiaryLike;
import com.project.moaidiary.entity.diary.like.DiaryLikeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class DiaryLikeService {
    private final DiaryLikeRepository diaryLikeRepository;

    public Optional<DiaryLike> getDiaryLikeByDiaryIdAndUserId(Long diaryId, Long userId) {
        return diaryLikeRepository.findDiaryLikeByDiaryIdAndUserId(diaryId, userId);
    }

    public void deleteDiaryLike(DiaryLike diaryLike) {
        diaryLikeRepository.delete(diaryLike);
    }

    public void addDiaryLike(DiaryLike diaryLike) {
        diaryLikeRepository.save(diaryLike);
    }
}
