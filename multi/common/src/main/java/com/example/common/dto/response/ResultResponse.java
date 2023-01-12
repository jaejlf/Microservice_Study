package com.example.common.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultResponse<T> {

    private int statusCode;
    private String errorCode;
    private String message;
    private T data;

    public static <T> ResponseEntity<Object> success(HttpStatus httpStatus, String message, T data) {
        return ResponseEntity
                .status(httpStatus)
                .body(ResultResponse.builder()
                        .statusCode(httpStatus.value())
                        .message(message)
                        .data(data)
                        .build());
    }
    public static ResponseEntity<Object> fail(HttpStatus httpStatus, String errorCode, String message) {
        return ResponseEntity
                .status(httpStatus)
                .body(ResultResponse.builder()
                        .statusCode(httpStatus.value())
                        .errorCode(errorCode)
                        .message(message)
                        .build());
    }

}
