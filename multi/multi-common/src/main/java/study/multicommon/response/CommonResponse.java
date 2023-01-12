package study.multicommon.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CommonResponse<T> {

    private static final int OK = 200;
    public static final int CREATED = 201;

    private int statusCode;
    private String message;
    private T data;

    public static <T> CommonResponse<Object> ok(String message, T data) {
        return CommonResponse.builder()
                .statusCode(OK)
                .message(message)
                .data(data)
                .build();
    }

    public static <T> CommonResponse<Object> create(String message, T data) {
        return CommonResponse.builder()
                .statusCode(CREATED)
                .message(message)
                .data(data)
                .build();
    }

}
