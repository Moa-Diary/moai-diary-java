package com.project.moaidiary.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum CustomErrorCode {
    NOT_EXIST_USER(HttpStatus.BAD_REQUEST, "회원 정보가 존재하지 않습니다.");

    private final HttpStatus httpStatus;
    private final String statusMessage;
}
