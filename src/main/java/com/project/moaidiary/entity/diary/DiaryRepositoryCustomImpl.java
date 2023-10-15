package com.project.moaidiary.entity.diary;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import static com.project.moaidiary.entity.diary.QDiary.diary;

public class DiaryRepositoryCustomImpl extends QuerydslRepositorySupport implements DiaryRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public DiaryRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory){
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
}
