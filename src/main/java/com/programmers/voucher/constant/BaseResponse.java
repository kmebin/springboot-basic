package com.programmers.voucher.constant;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> {
    private final int status;

    @JsonInclude(NON_NULL)
    private String message;

    @JsonInclude(NON_NULL)
    private T data;

    public static <T> BaseResponse<T> ok() {
        return new BaseResponse<>(HttpStatus.OK.value());
    }

    public static <T> BaseResponse<T> ok(T data) {
        return new BaseResponse<>(HttpStatus.OK.value(), null, data);
    }

    public static <T> BaseResponse<T> created() {
        return new BaseResponse<>(HttpStatus.CREATED.value());
    }

    public static <T> BaseResponse<T> created(T data) {
        return new BaseResponse<>(HttpStatus.CREATED.value(), null, data);
    }

    public static <T> BaseResponse<T> error(ErrorCode errorCode) {
        return new BaseResponse<>(errorCode.getStatus().value(), errorCode.getMessage(), null);
    }
}
