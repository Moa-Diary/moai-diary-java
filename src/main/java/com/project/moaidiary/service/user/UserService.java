package com.project.moaidiary.service.user;

import com.project.moaidiary.entity.user.User;
import com.project.moaidiary.entity.user.UserRepository;
import com.project.moaidiary.service.user.dto.CreateUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void createUser(CreateUserDto createUserDto) {
        userRepository.save(User.from(createUserDto));
    }
}
