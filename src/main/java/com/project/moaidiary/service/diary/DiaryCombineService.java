package com.project.moaidiary.service.diary;

import com.project.moaidiary.entity.diary.Diary;
import com.project.moaidiary.entity.diary.like.DiaryLike;
import com.project.moaidiary.entity.user.User;
import com.project.moaidiary.service.diary.dto.DiaryCountDto;
import com.project.moaidiary.service.diary.like.DiaryLikeService;
import com.project.moaidiary.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DiaryCombineService {
    private final DiaryService diaryService;
    private final DiaryLikeService diaryLikeService;
    private final UserService userService;

    public DiaryCountDto countDiaryByUserEmail(Long userId) {
        Long diaryCount = diaryService.getDiaryCountByUserId(userId);
        return DiaryCountDto.builder()
            .count(diaryCount)
            .build();
    }

    public void modifyDiaryLike(Long diaryId, Long userId){
        Optional<DiaryLike> diaryLike = diaryLikeService.getDiaryLikeByDiaryIdAndUserId(diaryId, userId);
        if (diaryLike.isPresent()) {
            diaryLikeService.deleteDiaryLike(diaryLike.get());
        } else{
            User user = userService.getUserByUserId(userId);
            Diary diary = diaryService.getDiaryByDiaryId(diaryId);
            diaryLikeService.addDiaryLike(DiaryLike.from(user, diary));
        }
    }
}