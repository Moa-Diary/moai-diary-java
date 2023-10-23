package com.project.moaidiary.entity.diary;

import com.project.moaidiary.service.diary.vo.DiaryDetailVo;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.Optional;

import static com.project.moaidiary.entity.diary.QDiary.diary;
import static com.project.moaidiary.entity.diary.like.QDiaryLike.diaryLike;
import static com.project.moaidiary.entity.diary.comment.QDiaryComment.diaryComment;

public class DiaryRepositoryCustomImpl extends QuerydslRepositorySupport implements DiaryRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public DiaryRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory) {
        super(Diary.class);
        this.queryFactory = jpaQueryFactory;
    }

    @Override
    public Long diaryCountByUserId(Long userId) {
        return queryFactory.select(diary.count())
            .from(diary)
            .where(diary.user.userId.eq(userId))
            .fetchFirst();
    }

    @Override
    public Optional<DiaryDetailVo> findDiaryDetailByDiaryId(Long diaryId) {
        return Optional.ofNullable(
            queryFactory.select(
                    Projections.fields(
                        DiaryDetailVo.class,
                        diary.diaryId,
                        diary.title,
                        diary.content,
                        diary.hashTag,
                        diary.emotionEnum,
                        diary.createdAt,
                        diary.isPublic,
                        diary.isAvailableComment
                    ))
                .from(diary)
                .where(diary.diaryId.eq(diaryId))
                .fetchFirst());
    }
}
