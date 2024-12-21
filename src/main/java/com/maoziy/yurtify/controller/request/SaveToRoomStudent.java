package com.maoziy.yurtify.controller.request;

import lombok.Data;

import java.util.UUID;

@Data
public class SaveToRoomStudent {

    private UUID roomId;
    private UUID studentId;
}
