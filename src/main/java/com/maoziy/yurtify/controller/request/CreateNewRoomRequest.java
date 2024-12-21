package com.maoziy.yurtify.controller.request;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateNewRoomRequest {

    private Integer capacity;
    private UUID dormId;
    private UUID floorId;
}
