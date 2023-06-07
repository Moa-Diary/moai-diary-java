package com.project.moaidiary.entity.user;

import lombok.*;

import javax.persistence.*;

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
