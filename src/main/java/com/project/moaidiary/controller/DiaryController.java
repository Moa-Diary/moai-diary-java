package com.project.moaidiary.controller;

import com.project.moaidiary.service.diary.DiaryCombineService;
import com.project.moaidiary.service.diary.dto.DiaryCommentDto;
import com.project.moaidiary.service.diary.dto.DiaryCountDto;
import com.project.moaidiary.service.diary.DiaryService;
import com.project.moaidiary.service.diary.dto.ModifyDiaryDto;
import com.project.moaidiary.service.diary.like.DiaryLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diary")
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryCombineService diaryCombineService;
    private final DiaryLikeService diaryLikeService;
    private final DiaryService diaryService;

    @GetMapping("/user/{userId}/count")
    public DiaryCountDto diaryCount(@PathVariable Long userId) {
        return diaryCombineService.countDiaryByUserEmail(userId);
    }

    @PutMapping("/{diaryId}/public/{isPublic}")
    public void changeIsPublic(@PathVariable Long diaryId, @PathVariable Boolean isPublic) {
        diaryService.modifyDiaryIsPublic(diaryId, isPublic);
    }

    @PutMapping("/{diaryId}/comment/available/{isAvailableComment}")
    public void changeIsCommentAvailable(@PathVariable Long diaryId, @PathVariable Boolean isAvailableComment){
        diaryService.modifyDiaryIsCommentAvailable(diaryId, isAvailableComment);
    }

    @PutMapping("/{diaryId}/user/{userId}/like")
    public void addDiaryLike(@PathVariable Long diaryId, @PathVariable Long userId){
        diaryCombineService.modifyDiaryLike(diaryId, userId);
    }

    @DeleteMapping("/{diaryId}")
    public void deleteDiary(@PathVariable Long diaryId) {
        diaryService.deleteById(diaryId);
    }

    @GetMapping("/user/{userId}/like/count")
    public DiaryCountDto userLikeDiaryCount(@PathVariable Long userId) {
        return DiaryCountDto.builder()
            .count(diaryLikeService.getDiaryLikeCountByUserId(userId))
            .build();
    }

    @PostMapping("/{diaryId}/comment")
    public void putDiaryComment(@PathVariable Long diaryId, @RequestBody DiaryCommentDto diaryCommentDto) {
        diaryCombineService.putDiaryComment(diaryId, diaryCommentDto);
    }
  
    @PutMapping("/{diaryId}")
    public void modifyDiary(@RequestBody ModifyDiaryDto modifyDiaryDto, @PathVariable Long diaryId) {
        diaryCombineService.modifyDiary(modifyDiaryDto, diaryId);
    }
}
