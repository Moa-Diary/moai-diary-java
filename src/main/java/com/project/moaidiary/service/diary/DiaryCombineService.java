package com.project.moaidiary.service.diary;

import com.project.moaidiary.entity.diary.Diary;
import com.project.moaidiary.entity.diary.like.DiaryLike;
import com.project.moaidiary.entity.user.User;
import com.project.moaidiary.service.diary.dto.DiaryCountDto;
import com.project.moaidiary.service.diary.dto.ModifyDiaryDto;
import com.project.moaidiary.service.diary.image.DiaryImageService;
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
    private final DiaryImageService diaryImageService;
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

    public void modifyDiary(ModifyDiaryDto modifyDiaryDto, Long diaryId) {
        Diary diary = diaryService.getDiaryByDiaryId(diaryId);
        diary.modifyContent(modifyDiaryDto);

        if (!modifyDiaryDto.getImagePaths().isEmpty()) {
            diaryImageService.removeDiaryImageByDiaryId(diaryId);
            diaryImageService.addImagePaths(diary, modifyDiaryDto.getImagePaths());
        }

        diaryService.putDiary(diary);
    }
}