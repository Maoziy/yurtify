package com.maoziy.yurtify.controller.request;

import lombok.Data;

import java.util.UUID;

@Data
public class QueryRoomRequest {

    private UUID dormId;
    private UUID floorId;
}
