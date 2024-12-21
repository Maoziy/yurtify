package com.maoziy.yurtify.model.exception;


import lombok.Getter;

import java.io.Serial;

@Getter
public class BaseException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -8046581280895159903L;

    private BaseError error;

    private String message;

    public BaseException(BaseError error) {
        this.error = error;
        this.message = String.format(error.getMessage());
    }

    public BaseException(BaseError error, String field) {
        this.error = error;
        this.message = String.format(error.getMessage(), field);
    }
}
