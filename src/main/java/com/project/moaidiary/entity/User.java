package com.project.moaidiary.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "moai_user")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name", nullable = false, length = 25)
    private String userName;

    @Column(name = "user_display_name", nullable = false, length = 50)
    private String userDisplayName;

    @Column(name = "user_email", unique = true, nullable = false, length = 30)
    private String userEmail;

    @Column(name = "user_phone", nullable = false, length = 15)
    private String userPhone;

    @Column(name = "firebase_unique_key", unique = true, nullable = false, length = 100)
    private String firebaseUniqueKey;

    @Column(name = "profile_image_name", nullable = false, length = 30)
    private String profileImageName;

}