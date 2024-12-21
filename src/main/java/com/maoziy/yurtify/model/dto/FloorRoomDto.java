package com.maoziy.yurtify.model.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class FloorRoomDto {

    private UUID floorId;
    private Integer numberOfRooms;
    private Integer floorNumber;
}
