package com.maoziy.yurtify.model.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class RoomDto {

    private UUID id;
    private String roomName;
    private Integer capacity;
    private Integer numberOfStudent;
}
