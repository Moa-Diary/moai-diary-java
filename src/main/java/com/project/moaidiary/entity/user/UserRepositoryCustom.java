package com.project.moaidiary.entity.user;

import java.util.Optional;

public interface UserRepositoryCustom {
    Optional<User> findUserByUserEmail(String userEmail);
    Boolean existsByUserEmail(String email);
}
