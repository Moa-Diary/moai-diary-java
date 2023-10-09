package com.project.moaidiary.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException{
    private final CustomErrorCode customErrorCode;
    private final String detailMessage;

    public CustomException(CustomErrorCode customErrorCode) {
        super(customErrorCode.getStatusMessage());
        this.customErrorCode = customErrorCode;
        this.detailMessage = customErrorCode.getStatusMessage();
    }
}
