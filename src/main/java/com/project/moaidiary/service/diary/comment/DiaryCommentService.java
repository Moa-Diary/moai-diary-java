package com.project.moaidiary.service.diary.comment;

import com.project.moaidiary.entity.diary.comment.DiaryComment;
import com.project.moaidiary.entity.diary.comment.DiaryCommentRepository;
import com.project.moaidiary.exception.CustomException;
import com.project.moaidiary.service.diary.comment.vo.DiaryCommentDetailVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.project.moaidiary.exception.CustomErrorCode.NOT_EXIST_DIARY_COMMENT;

@Service
@Slf4j
@RequiredArgsConstructor
public class DiaryCommentService {
    private final DiaryCommentRepository diaryCommentRepository;

    public void putDiaryComment(DiaryComment diaryComment) {
        diaryCommentRepository.save(diaryComment);
    }

    public DiaryComment getDiaryCommentByCommentId(Long commentId) {
        return diaryCommentRepository.findById(commentId).orElseThrow(() -> new CustomException(NOT_EXIST_DIARY_COMMENT));
    }

    public List<DiaryCommentDetailVo> getDiaryCommentWithLikeCountByDiaryId(Long diaryId) {
        return diaryCommentRepository.findDiaryCommentWithLikeCountByDiaryId(diaryId);
    }
}
