package kr.rene.template.sampledomain1.common.model.api;

import org.springframework.http.HttpStatus;

/**
 * @author : Rene Choi
 * @since : 2023/12/19
 */
public record CommonApiResponse<T>(String code, String message, HttpStatus httpStatus, T data) {

    public static <T> CommonApiResponse<T> OK(ResponseCodeCapable responseCode, T data) {
        return new CommonApiResponse<>(responseCode.getCode(), responseCode.getMessage(), responseCode.getHttpStatus(), data);
    }

    public static <T> CommonApiResponse<T> OK() {
        return OK(ResponseCodeCapable.SUCCESS, null);
    }
}