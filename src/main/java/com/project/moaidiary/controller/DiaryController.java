package com.project.moaidiary.controller;

import com.project.moaidiary.service.diary.DiaryCombineService;
import com.project.moaidiary.service.diary.comment.dto.DiaryCommentDto;
import com.project.moaidiary.service.diary.dto.*;
import com.project.moaidiary.service.diary.DiaryService;
import com.project.moaidiary.service.diary.like.DiaryLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import retrofit2.http.Path;

import java.util.List;

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

    @GetMapping("/{diaryId}")
    public DiaryDetailDto getDiary(@PathVariable Long diaryId){
        return diaryCombineService.getDiaryDetail(diaryId);
    }

    @GetMapping("/user/{userId}")
    public DiaryPageDto getDiaryList(@PathVariable Long userId, Pageable pageable){
        return diaryCombineService.getDiaryList(userId, pageable);
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

    @PutMapping("/comment/{commentId}/user/{userId}/like")
    public void diaryCommentLike(@PathVariable Long commentId, @PathVariable Long userId) {
        diaryCombineService.modifyDiaryComment(commentId, userId);
    }

    @PostMapping("/internal-api/user/{userId}")
    public void addDiary(@PathVariable Long userId, @RequestBody AddDiaryDto addDiaryDto ){
        diaryCombineService.addDiary(userId, addDiaryDto);
    }
}
