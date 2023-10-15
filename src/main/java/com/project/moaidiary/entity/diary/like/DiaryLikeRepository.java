package com.project.moaidiary.entity.diary.like;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaryLikeRepository extends JpaRepository<DiaryLike, Long>, DiaryLikeRepositoryCustom {
}
