package com.project.moaidiary.service.diary.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ModifyDiaryDto {
    private String title;
    private String content;
    private List<String> hashTags;
    @Size(max = 3, message = "사진은 최대 3장까지만 업로드 가능합니다.")
    private List<String> imagePaths;
}