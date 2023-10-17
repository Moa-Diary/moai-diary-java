package com.project.moaidiary.moai_enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EmotionEnum {
    HAPPY("행복"),
    CONTENTED("만족"),
    SAD("슬픔");
    private final String description;
}
