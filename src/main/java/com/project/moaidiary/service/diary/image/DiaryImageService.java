package com.project.moaidiary.service.diary.image;

import com.project.moaidiary.entity.diary.Diary;
import com.project.moaidiary.entity.diary.image.DiaryImage;
import com.project.moaidiary.entity.diary.image.DiaryImageRepository;
import com.project.moaidiary.exception.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class DiaryImageService {
    private final DiaryImageRepository diaryImageRepository;

    public void removeDiaryImageByDiaryId (Long diaryId) {
        List<DiaryImage> diaryImageList = this.getDiaryImagesByDiaryId(diaryId);
        diaryImageRepository.deleteAll(diaryImageList);
    }

    public List<DiaryImage> getDiaryImagesByDiaryId(Long diaryId) {
        return diaryImageRepository.findAllByDiaryId(diaryId);
    }

    public void addImagePaths(Diary diary, List<String> imagePaths) {
        List<DiaryImage> diaryImageList = imagePaths.stream().map(it -> DiaryImage.builder().diary(diary).imagePath(it).build()).collect(Collectors.toList());
        diaryImageRepository.saveAll(diaryImageList);
    }
}
