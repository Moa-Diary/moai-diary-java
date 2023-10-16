package com.project.moaidiary.entity.diary.image;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;
import java.util.Optional;

import static com.project.moaidiary.entity.diary.image.QDiaryImage.diaryImage;

public class DiaryImageRepositoryCustomImpl extends QuerydslRepositorySupport implements DiaryImageRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public DiaryImageRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory){
        super(DiaryImage.class);
        this.queryFactory = jpaQueryFactory;
    }

    @Override
    public List<DiaryImage> findAllByDiaryId(Long diaryId) {
        return queryFactory.select(Projections.constructor(
            DiaryImage.class,
            diaryImage.diaryImageId,
            diaryImage.diary,
            diaryImage.imagePath))
        .from(diaryImage)
        .where(diaryImage.diary.diaryId.eq(diaryId))
        .fetch();
    }
}
