package com.project.moaidiary.entity.diary.comment;

import com.project.moaidiary.entity.diary.Diary;
import com.project.moaidiary.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "diary_comment")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiaryComment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diary_comment_id")
    private Long diaryCommentId;

    @ManyToOne
    @JoinColumn(name = "diary_id")
    private Diary diary;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "content", nullable = false, length = 300)
    private String comment;
}
