package com.project.moaidiary.entity.diary.comment.like;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.Optional;

import static com.project.moaidiary.entity.diary.comment.like.QDiaryCommentLike.diaryCommentLike;


public class DiaryCommentLikeRepositoryCustomImpl extends QuerydslRepositorySupport implements DiaryCommentLikeRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public DiaryCommentLikeRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory) {
        super(DiaryCommentLike.class);
        this.queryFactory = jpaQueryFactory;
    }

    @Override
    public Optional<DiaryCommentLike> findByDiaryCommentIdAndUserId(Long commentId, Long userId) {
        return Optional.ofNullable(
            queryFactory.select(
                    Projections.constructor(
                        DiaryCommentLike.class,
                        diaryCommentLike.diaryCommentLikeId,
                        diaryCommentLike.diaryComment,
                        diaryCommentLike.user
                    )
                )
                .from(diaryCommentLike)
                .where(diaryCommentLike.diaryComment.diaryCommentId.eq(commentId).and(diaryCommentLike.user.userId.eq(userId)))
                .fetchFirst()
        );
    }

    @Override
    public Long findDiaryCommentLikeCountByDiaryCommentId(Long diaryCommentId) {
        return queryFactory.select(
                diaryCommentLike.count()
            )
            .from(diaryCommentLike)
            .where(diaryCommentLike.diaryComment.diaryCommentId.eq(diaryCommentId))
            .fetchFirst();
    }
}
