package com.project.moaidiary.exception;

import lombok.*;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomErrorResponse {
    private int status;
    private String code;
    private String message;

    public static ResponseEntity<CustomErrorResponse> toResponseEntity(CustomErrorCode e) {
        return ResponseEntity.status(e.getHttpStatus())
            .body(CustomErrorResponse.builder()
                .status(e.getHttpStatus().value())
                .code(e.name())
                .message(e.getStatusMessage())
                .build()
            );
    }
}
