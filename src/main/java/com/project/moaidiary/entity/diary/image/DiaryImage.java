package com.project.moaidiary.entity.diary.image;

import com.project.moaidiary.entity.diary.Diary;
import com.project.moaidiary.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "diary_image")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiaryImage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diary_image_id")
    private Long diaryImageId;

    @ManyToOne
    @JoinColumn(name = "diary_id")
    private Diary diary;

    @Column(name = "image_path", nullable = false, length = 100)
    private String imagePath;
}
