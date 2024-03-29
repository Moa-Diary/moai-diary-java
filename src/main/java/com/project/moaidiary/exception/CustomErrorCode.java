package com.project.moaidiary.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum CustomErrorCode {
    NOT_EXIST_USER(HttpStatus.BAD_REQUEST, "회원 정보가 존재하지 않습니다."),
    NOT_EXIST_DIARY(HttpStatus.BAD_REQUEST, "일기 정보가 존재하지 않습니다."),
    NOT_EXIST_DIARY_COMMENT(HttpStatus.BAD_REQUEST, "일기 댓글 정보가 존재하지 않습니다.");


    private final HttpStatus httpStatus;
    private final String statusMessage;
}
