package com.project.moaidiary.service.user;

import com.project.moaidiary.entity.user.User;
import com.project.moaidiary.entity.user.UserRepository;
import com.project.moaidiary.exception.CustomException;
import com.project.moaidiary.service.user.dto.CreateUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.project.moaidiary.exception.CustomErrorCode.NOT_EXIST_USER;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void createUser(CreateUserDto createUserDto) {
        userRepository.save(User.from(createUserDto));
    }

    public User getUserByUserEmail(String userEmail){
        return userRepository.findUserByUserEmail(userEmail).orElseThrow(() -> new CustomException(NOT_EXIST_USER));
    }

    public User getUserByUserId(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new CustomException(NOT_EXIST_USER));
    }

    public void putUser(User user) {
        userRepository.save(user);
    }

    public Boolean isExistUserEmail(String userEmail) {
        return userRepository.existsByUserEmail(userEmail);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
