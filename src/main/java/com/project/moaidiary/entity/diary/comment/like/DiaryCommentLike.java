package com.project.moaidiary.entity.diary.comment.like;

import com.project.moaidiary.entity.diary.comment.DiaryComment;
import com.project.moaidiary.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "diary_comment_like")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiaryCommentLike implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diary_comment_like_id")
    private Long diaryCommentLikeId;

    @ManyToOne
    @JoinColumn(name = "diary_comment_id")
    private DiaryComment diaryComment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public static DiaryCommentLike from (DiaryComment diaryComment, User user) {
        return DiaryCommentLike.builder()
            .user(user)
            .diaryComment(diaryComment)
            .build();
    }
}
