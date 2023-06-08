package com.project.moaidiary.moai_enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum ImageProfile {
    IMG_PROFILE_CHERRY(1L, "img_profile_cherry"),
    IMG_PROFILE_AVOCADO(2L, "img_profile_avocado"),
    IMG_PROFILE_CARROT(3L, "img_profile_carrot"),
    IMG_PROFILE_POOP(4L, "img_profile_poop"),
    IMG_PROFILE_HEART(5L, "img_profile_heart");

    private final Long randomUniqueKey;
    private final String description;

    public static ImageProfile getImageProfileByDescription(String description){
        return Arrays.stream(ImageProfile.values()).filter(it -> it.getDescription().equals(description)).findFirst().orElseThrow();
    }
}
