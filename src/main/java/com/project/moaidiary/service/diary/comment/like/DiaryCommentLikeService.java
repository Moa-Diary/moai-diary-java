package com.project.moaidiary.service.diary.comment.like;

import com.project.moaidiary.entity.diary.comment.like.DiaryCommentLike;
import com.project.moaidiary.entity.diary.comment.like.DiaryCommentLikeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class DiaryCommentLikeService {
    private final DiaryCommentLikeRepository diaryCommentLikeRepository;

    public void addDiaryLikeComment(DiaryCommentLike diaryCommentLike) {
        diaryCommentLikeRepository.save(diaryCommentLike);
    }

    public Optional<DiaryCommentLike> getDiaryCommentLikeByDiaryCommentIdAndUserId(Long commentId, Long userId){
        return diaryCommentLikeRepository.findByDiaryCommentIdAndUserId(commentId, userId);
    }

    public void deleteDiaryCommentLike(DiaryCommentLike diaryCommentLike) {
        diaryCommentLikeRepository.delete(diaryCommentLike);
    }
}
