package com.project.moaidiary.entity.diary.comment;

import com.project.moaidiary.service.diary.comment.vo.DiaryCommentDetailVo;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

import static com.project.moaidiary.entity.diary.comment.QDiaryComment.diaryComment;

public class DiaryCommentRepositoryCustomImpl extends QuerydslRepositorySupport implements DiaryCommentRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public DiaryCommentRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory) {
        super(DiaryComment.class);
        this.queryFactory = jpaQueryFactory;
    }

    @Override
    public List<DiaryCommentDetailVo> findDiaryCommentWithLikeCountByDiaryId(Long diaryId) {
        return queryFactory.select(
                Projections.fields(
                    DiaryCommentDetailVo.class,
                    diaryComment.diaryCommentId.as("commentId"),
                    diaryComment.comment,
                    diaryComment.user.userDisplayName.as("commentBy")
                )
            )
            .from(diaryComment)
            .where(diaryComment.diary.diaryId.eq(diaryId))
            .fetch();
    }
}
