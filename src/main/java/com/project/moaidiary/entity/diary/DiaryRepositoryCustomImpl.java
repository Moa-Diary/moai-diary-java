package com.project.moaidiary.entity.diary;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class DiaryRepositoryCustomImpl extends QuerydslRepositorySupport implements DiaryRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public DiaryRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory) {
        super(Diary.class);
        this.queryFactory = jpaQueryFactory;
    }
}
