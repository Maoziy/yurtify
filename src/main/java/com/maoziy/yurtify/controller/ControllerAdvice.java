package com.maoziy.yurtify.controller;

import com.maoziy.yurtify.controller.response.BaseResponse;
import com.maoziy.yurtify.model.exception.BaseException;
import com.maoziy.yurtify.model.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public BaseResponse<String> handleException(BaseException exception) {
        return BaseResponse.fail(exception.getError(),exception.getMessage());
    }
}
