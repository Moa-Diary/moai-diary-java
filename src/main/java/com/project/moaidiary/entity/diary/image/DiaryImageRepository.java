package com.project.moaidiary.entity.diary.image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaryImageRepository extends JpaRepository<DiaryImage, Long>, DiaryImageRepositoryCustom {
}
