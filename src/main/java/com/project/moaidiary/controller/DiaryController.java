package com.project.moaidiary.controller;

import com.project.moaidiary.service.diary.dto.DiaryCombineService;
import com.project.moaidiary.service.diary.dto.DiaryCountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diary")
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryCombineService diaryCombineService;

    @GetMapping("/user/{userId}/count")
    public DiaryCountDto diaryCount(@PathVariable Long userId) {
        return diaryCombineService.countDiaryByUserEmail(userId);
    }
}
