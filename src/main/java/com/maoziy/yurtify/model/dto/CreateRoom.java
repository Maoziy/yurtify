package com.maoziy.yurtify.model.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateRoom {
    private Integer capacity;
    private UUID dormId;
    private UUID floorId;
    private Integer number;
}
