package com.project.moaidiary.entity.user;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.Optional;

import static com.project.moaidiary.entity.user.QUser.user;

public class UserRepositoryCustomImpl extends QuerydslRepositorySupport implements UserRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public UserRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory){
        super(User.class);
        this.queryFactory = jpaQueryFactory;
    }

    @Override
    public Optional<User> findUserByUserEmail(String userEmail) {
        return Optional.ofNullable(queryFactory.select(Projections.constructor(
                User.class,
                user.userId,
                user.userName,
                user.userDisplayName,
                user.userEmail,
                user.userPhone,
                user.firebaseUniqueKey,
                user.imageProfileName
            ))
            .from(user)
            .where(user.userEmail.eq(userEmail)).fetchOne());
    }
}
