package com.project.moaidiary.service.diary.dto;

import com.project.moaidiary.service.diary.comment.dto.DiaryCommentDetailDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiaryPageDto {
    private List<DiaryDetailDto> content;
    private int totalPages;
    private Long totalElements;
    private int size;
    private int page;
    private Boolean hasMoreResult;
}
