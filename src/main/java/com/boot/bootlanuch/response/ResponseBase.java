package com.boot.bootlanuch.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gcg
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseBase {
    private String code;
    private boolean isok;
    private String message;
    private Object data;

    public static ResponseBase success(Object data) {
        ResponseBase responseBase = ResponseBase.builder()
                .code("200")
                .isok(true)
                .message("处理成功")
                .data(data)
                .build();
        return responseBase;
    }

    public static ResponseBase success() {
        ResponseBase responseBase = ResponseBase.builder()
                .code("200")
                .isok(true)
                .message("处理成功")
                .build();
        return responseBase;
    }

    public static ResponseBase success(String message, Object data) {
        ResponseBase responseBase = ResponseBase.builder()
                .code("200")
                .isok(true)
                .message(message)
                .data(data)
                .build();
        return responseBase;
    }

    public static ResponseBase success(String code, String message, Object data) {
        ResponseBase responseBase = ResponseBase.builder()
                .code(code)
                .isok(true)
                .message(message)
                .data(data)
                .build();
        return responseBase;
    }

    public static ResponseBase error(String message, String code) {
        ResponseBase responseBase = ResponseBase.builder()
                .code(code)
                .isok(false)
                .message(message)
                .build();
        return responseBase;
    }

    public static ResponseBase error(String message) {
        ResponseBase responseBase = ResponseBase.builder()
                .code("500")
                .isok(false)
                .message(message)
                .build();
        return responseBase;
    }
}
