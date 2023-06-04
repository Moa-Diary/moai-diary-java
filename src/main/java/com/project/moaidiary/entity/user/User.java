package com.project.moaidiary.entity.user;

import com.project.moaidiary.moai_enum.ImageProfile;
import com.project.moaidiary.service.user.dto.CreateUserDto;
import jakarta.persistence.*;
import lombok.*;

import static com.project.moaidiary.moai_enum.ImageProfile.IMG_PROFILE_CHERRY;

@Entity
@Table(name = "moai_users")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name", nullable = false, length = 20)
    private String userName;

    @Column(name = "user_display_name", nullable = false, length = 50, unique = true)
    private String userDisplayName;

    @Column(name = "user_email", nullable = false, length = 100, unique = true)
    private String userEmail;

    @Column(name = "user_phone", length = 15)
    private String userPhone;

    @Column(name = "firebase_unique_key", nullable = false, length = 30)
    private String firebaseUniqueKey;

    @Column(name = "image_profile_name")
    private ImageProfile imageProfileName;

    public static User from(CreateUserDto createUserDto) {
        return User.builder()
            .userName(createUserDto.getUserName())
            .userDisplayName(createUserDto.getUserName())
            .userEmail(createUserDto.getUserEmail())
            .userPhone(null)
            .firebaseUniqueKey(createUserDto.getFirebaseUniqueKey())
            .imageProfileName(IMG_PROFILE_CHERRY) /* 하드코딩 - 이후 랜덤값으로 변경 필요*/
        .build();
    }
}
