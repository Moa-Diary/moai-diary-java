package com.project.moaidiary.entity.user;

public interface UserRepositoryCustom {
    User findUserByUserEmail(String userEmail);
    Boolean existsByUserEmail(String email);
}
