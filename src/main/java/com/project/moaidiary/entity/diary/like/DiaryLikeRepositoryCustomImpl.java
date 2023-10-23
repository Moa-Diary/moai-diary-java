package com.project.moaidiary.entity.diary.like;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.Optional;

import static com.project.moaidiary.entity.diary.like.QDiaryLike.diaryLike;

public class DiaryLikeRepositoryCustomImpl extends QuerydslRepositorySupport implements DiaryLikeRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public DiaryLikeRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory){
        super(DiaryLike.class);
        this.queryFactory = jpaQueryFactory;
    }

    @Override
    public Optional<DiaryLike> findDiaryLikeByDiaryIdAndUserId(Long diaryId, Long userId) {
        return Optional.ofNullable(
            queryFactory.select(
                    Projections.constructor(
                        DiaryLike.class,
                        diaryLike.diaryLikeId,
                        diaryLike.diary,
                        diaryLike.user
                    )).from(diaryLike)
                .where(diaryLike.diary.diaryId.eq(diaryId).and(diaryLike.user.userId.eq(userId)))
                .fetchFirst()
        );
    }

    @Override
    public Long findDiaryLikeCountByUserId(Long userId) {
        return queryFactory.select(diaryLike.count())
            .from(diaryLike)
            .where(diaryLike.user.userId.eq(userId))
            .fetchFirst();
    }

    @Override
    public Long findDiaryLikeCountByDiaryId(Long diaryId) {
        return queryFactory.select(diaryLike.count())
            .from(diaryLike)
            .where(diaryLike.diary.diaryId.eq(diaryId))
            .fetchFirst();
    }
}
