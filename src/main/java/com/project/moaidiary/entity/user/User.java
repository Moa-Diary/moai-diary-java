package com.project.moaidiary.entity.user;

import jakarta.persistence.*;
import lombok.*;

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
}
