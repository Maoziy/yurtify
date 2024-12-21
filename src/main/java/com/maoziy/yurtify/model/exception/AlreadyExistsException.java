package com.maoziy.yurtify.model.exception;

public class AlreadyExistsException extends BaseException {
    public AlreadyExistsException(String name) {
        super(CommonErrors.ALREADY_EXISTS_ERROR, name);
    }
}
