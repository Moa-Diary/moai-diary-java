package com.project.moaidiary.entity.diary.like;

import com.project.moaidiary.entity.diary.Diary;
import com.project.moaidiary.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "diary_like")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiaryLike implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diary_like_id")
    private Long diaryLikeId;

    @ManyToOne
    @JoinColumn(name = "diary_id")
    private Diary diary;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public static DiaryLike from (User user, Diary diary) {
        return DiaryLike.builder()
            .user(user)
            .diary(diary)
            .build();
    }
}
