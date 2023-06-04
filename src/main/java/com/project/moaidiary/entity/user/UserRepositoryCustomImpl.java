package com.project.moaidiary.entity.user;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class UserRepositoryCustomImpl extends QuerydslRepositorySupport implements UserRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public UserRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory){
        super(User.class);
        this.queryFactory = jpaQueryFactory;
    }

    @Override
    public User findUserByUserEmail(String userEmail) {
        //return queryFactory.select(Projections.bean(User.class)).from(user).where(user.getUserEmail().eq(userEmail)).fetch();
        return null;
    }

    @Override
    public Boolean existsByUserEmail(String email) {
        return true;
    }
}
