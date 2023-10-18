package com.project.moaidiary.service.diary.comment;

import com.project.moaidiary.entity.diary.comment.DiaryComment;
import com.project.moaidiary.entity.diary.comment.DiaryCommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DiaryCommentService {
    private final DiaryCommentRepository diaryCommentRepository;

    public void putDiaryComment(DiaryComment diaryComment) {
        diaryCommentRepository.save(diaryComment);
    }
}
