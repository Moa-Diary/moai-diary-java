package com.project.moaidiary.entity.diary;

import com.project.moaidiary.entity.user.User;
import com.project.moaidiary.moai_enum.EmotionEnum;
import com.project.moaidiary.service.diary.dto.ModifyDiaryDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "diary")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Diary implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diary_id")
    private Long diaryId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "title", nullable = false, length = 50, unique = true)
    private String title;

    @Column(name = "content", nullable = false, length = 500, unique = true)
    private String content;

    @Column(name = "hash_tag", nullable = false, length = 30)
    private String hashTag;

    @Column(name = "emotion")
    private EmotionEnum emotionEnum;

    @Column(name = "is_public", nullable = false, length = 30)
    private boolean isPublic;

    @Column(name = "is_available_comment", nullable = false, length = 30)
    private boolean isAvailableComment;

    @Column(name = "created_at", nullable = false, length = 30)
    private Date createdAt;

    public void modifyIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public void modifyIsAvailableComment(Boolean isAvailableComment) {
        this.isAvailableComment = isAvailableComment;
    }

    public void modifyContent(ModifyDiaryDto modifyDiaryDto) {
        if (Objects.nonNull(modifyDiaryDto.getTitle())){
            this.title = modifyDiaryDto.getTitle();
        }
        if (Objects.nonNull(modifyDiaryDto.getContent())){
            this.content = modifyDiaryDto.getContent();
        }
        if (!modifyDiaryDto.getHashTags().isEmpty()){
            this.hashTag = String.join(",", modifyDiaryDto.getHashTags());
        }
    }
}
