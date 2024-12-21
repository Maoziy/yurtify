package com.maoziy.yurtify.model.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonErrors implements BaseError {

    NOT_FOUND_EXCEPTION("Record not founded with %s"), ALREADY_EXISTS_ERROR("Record already exists with %s");

    private final String message;
}
