package com.maoziy.yurtify.model.exception;

public class NotFoundException extends BaseException{
    public NotFoundException(String field) {
        super(CommonErrors.NOT_FOUND_EXCEPTION,field);
    }
}
