package com.project.moaidiary.entity.diary.like;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class DiaryLikeRepositoryCustomImpl extends QuerydslRepositorySupport implements DiaryLikeRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public DiaryLikeRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory){
        super(DiaryLike.class);
        this.queryFactory = jpaQueryFactory;
    }

}
