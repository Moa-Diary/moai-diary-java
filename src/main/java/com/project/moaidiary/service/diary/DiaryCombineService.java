package com.project.moaidiary.service.diary;

import com.project.moaidiary.entity.diary.Diary;
import com.project.moaidiary.entity.diary.comment.DiaryComment;
import com.project.moaidiary.entity.diary.comment.like.DiaryCommentLike;
import com.project.moaidiary.entity.diary.image.DiaryImage;
import com.project.moaidiary.entity.diary.like.DiaryLike;
import com.project.moaidiary.entity.user.User;
import com.project.moaidiary.moai_enum.EmotionEnum;
import com.project.moaidiary.service.diary.comment.DiaryCommentService;
import com.project.moaidiary.service.diary.comment.dto.DiaryCommentDetailDto;
import com.project.moaidiary.service.diary.comment.like.DiaryCommentLikeService;
import com.project.moaidiary.service.diary.comment.dto.DiaryCommentDto;
import com.project.moaidiary.service.diary.dto.*;
import com.project.moaidiary.service.diary.image.DiaryImageService;
import com.project.moaidiary.service.diary.like.DiaryLikeService;
import com.project.moaidiary.service.diary.vo.DiaryDetailVo;
import com.project.moaidiary.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DiaryCombineService {
    private final DiaryService diaryService;
    private final DiaryLikeService diaryLikeService;
    private final DiaryCommentService diaryCommentService;
    private final DiaryImageService diaryImageService;
    private final DiaryCommentLikeService diaryCommentLikeService;
    private final UserService userService;

    public DiaryCountDto countDiaryByUserEmail(Long userId) {
        Long diaryCount = diaryService.getDiaryCountByUserId(userId);
        return DiaryCountDto.builder()
            .count(diaryCount)
            .build();
    }

    public void modifyDiaryLike(Long diaryId, Long userId) {
        Optional<DiaryLike> diaryLike = diaryLikeService.getDiaryLikeByDiaryIdAndUserId(diaryId, userId);
        if (diaryLike.isPresent()) {
            diaryLikeService.deleteDiaryLike(diaryLike.get());
        } else {
            User user = userService.getUserByUserId(userId);
            Diary diary = diaryService.getDiaryByDiaryId(diaryId);
            diaryLikeService.addDiaryLike(DiaryLike.from(user, diary));
        }
    }

    public void putDiaryComment(Long diaryId, DiaryCommentDto diaryCommentDto) {
        Diary diary = diaryService.getDiaryByDiaryId(diaryId);
        User user = userService.getUserByUserId(diaryCommentDto.getUserId());

        diaryCommentService.putDiaryComment(DiaryComment.builder()
            .diary(diary)
            .user(user)
            .comment(diaryCommentDto.getComment())
            .build()
        );
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

    public void modifyDiaryComment(Long commentId, Long userId) {
        Optional<DiaryCommentLike> diaryCommentLike = diaryCommentLikeService.getDiaryCommentLikeByDiaryCommentIdAndUserId(commentId, userId);
        if (diaryCommentLike.isPresent()) {
            diaryCommentLikeService.deleteDiaryCommentLike(diaryCommentLike.get());
        } else {
            DiaryComment diaryComment = diaryCommentService.getDiaryCommentByCommentId(commentId);
            User user = userService.getUserByUserId(userId);
            diaryCommentLikeService.addDiaryLikeComment(DiaryCommentLike.builder().diaryComment(diaryComment).user(user).build());
        }
    }

    public DiaryDetailDto getDiaryDetail(Long diaryId) {
        DiaryDetailVo diaryDetailVo = diaryService.getDiaryDetailByDiaryId(diaryId);
        List<String> diaryImageUrls = diaryImageService.getDiaryImagesByDiaryId(diaryId).stream().map(DiaryImage::getImagePath).collect(Collectors.toList());
        Long diaryLikeCount = diaryLikeService.getDiaryLikeCountByDiaryId(diaryId);

        List<DiaryCommentDetailDto> diaryCommentDetailDtoList = diaryCommentService.getDiaryCommentWithLikeCountByDiaryId(diaryId).stream().map(it ->
            DiaryCommentDetailDto.builder()
                .commentBy(it.getCommentBy())
                .commentByImage("")
                .comment(it.getComment())
                .commentId(it.getCommentId())
                .commentLikeCount(diaryCommentLikeService.getDiaryCommentLikeCountByDiaryCommentId(it.getCommentId()))
                .build()
        ).collect(Collectors.toList());

        return DiaryDetailDto.builder()
            .diaryId(diaryDetailVo.getDiaryId())
            .userDisplayName(diaryDetailVo.getUserDisplayName())
            .userProfileImage(diaryDetailVo.getImageProfileName().getDescription())
            .title(diaryDetailVo.getTitle())
            .content(diaryDetailVo.getContent())
            .likeCount(diaryLikeCount)
            .commentCount(diaryCommentDetailDtoList.size())
            .hashTags(List.of(diaryDetailVo.getHashTag().split(",")))
            .emotion(diaryDetailVo.getEmotion())
            .createdAt(diaryDetailVo.getCreatedAt())
            .isPublic(diaryDetailVo.getIsPublic())
            .isAvailableComment(diaryDetailVo.getIsAvailableComment())
            .imageUrls(diaryImageUrls)
            .comment(diaryCommentDetailDtoList)
            .build();
    }

    public DiaryPageDto getDiaryList(Long userId, Pageable pageable) {
        Page<DiaryDetailVo> diaryDetailVo = diaryService.getDiaryDetailByUserId(userId, pageable);

        List<DiaryDetailDto> diaryDetailDtoList = diaryDetailVo.stream().map(
            diaryDetail -> {
                List<String> diaryImageUrls = diaryImageService.getDiaryImagesByDiaryId(diaryDetail.getDiaryId()).stream().map(DiaryImage::getImagePath).collect(Collectors.toList());
                Long diaryLikeCount = diaryLikeService.getDiaryLikeCountByDiaryId(diaryDetail.getDiaryId());

                List<DiaryCommentDetailDto> diaryCommentDetailDtoList = diaryCommentService.getDiaryCommentWithLikeCountByDiaryId(diaryDetail.getDiaryId()).stream().map(it ->
                    DiaryCommentDetailDto.builder()
                        .commentBy(it.getCommentBy())
                        .commentByImage("")
                        .comment(it.getComment())
                        .commentId(it.getCommentId())
                        .commentLikeCount(diaryCommentLikeService.getDiaryCommentLikeCountByDiaryCommentId(it.getCommentId()))
                        .build()
                ).collect(Collectors.toList());

                return DiaryDetailDto.builder()
                    .diaryId(diaryDetail.getDiaryId())
                    .userDisplayName(diaryDetail.getUserDisplayName())
                    .userProfileImage(diaryDetail.getImageProfileName().getDescription())
                    .title(diaryDetail.getTitle())
                    .content(diaryDetail.getContent())
                    .likeCount(diaryLikeCount)
                    .commentCount(diaryCommentDetailDtoList.size())
                    .hashTags(List.of(diaryDetail.getHashTag().split(",")))
                    .emotion(diaryDetail.getEmotion())
                    .createdAt(diaryDetail.getCreatedAt())
                    .isPublic(diaryDetail.getIsPublic())
                    .isAvailableComment(diaryDetail.getIsAvailableComment())
                    .imageUrls(diaryImageUrls)
                    .comment(diaryCommentDetailDtoList)
                    .build();
            }
        ).collect(Collectors.toList());

        return DiaryPageDto.builder()
            .content(diaryDetailDtoList)
            .totalPages(diaryDetailVo.getTotalPages())
            .totalElements(diaryDetailVo.getTotalElements())
            .size(diaryDetailVo.getSize())
            .page(diaryDetailVo.getNumber())
            .hasMoreResult(diaryDetailVo.hasPrevious())
            .build();
    }

    public void addDiary(Long userId, AddDiaryDto addDiaryDto) {
        User user = userService.getUserByUserId(userId);
        diaryService.addDiary(Diary.builder()
                .user(user)
                .title(addDiaryDto.getTitle())
                .content(addDiaryDto.getContent())
                .hashTag(addDiaryDto.getHashTag())
                .emotionEnum(EmotionEnum.valueOf(addDiaryDto.getEmotion()))
                .isPublic(addDiaryDto.isPublic())
                .isAvailableComment(addDiaryDto.isAvailableComment())
                .createdAt(LocalDate.now())
            .build());
    }
}