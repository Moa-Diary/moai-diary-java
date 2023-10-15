package com.project.moaidiary.entity.diary.comment;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class DiaryCommentRepositoryCustomImpl extends QuerydslRepositorySupport implements DiaryCommentRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public DiaryCommentRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory){
        super(DiaryComment.class);
        this.queryFactory = jpaQueryFactory;
    }

}
