package com.maoziy.yurtify.controller.response;

import com.maoziy.yurtify.model.exception.BaseError;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

//todo: bunun abstract olması ne kadar mantıklı ?
@Builder
@Getter
public class BaseResponse<T> {

    private HttpStatus status;
    private BaseError error;
    private T data;

    public static <T> BaseResponse<T> success(T data) {
        return BaseResponse.<T>builder()
                .status(HttpStatus.OK)
                .data(data)
                .error(null)
                .build();
    }

    public static <T> BaseResponse<T> fail(BaseError error,T data) {
        return BaseResponse.<T>builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .data(data)
                .error(error)
                .build();
    }
}
