package com.maoziy.yurtify.model.dto;

import com.maoziy.yurtify.model.entity.DormitoryEntity;
import lombok.Data;

import java.util.UUID;

@Data
public class FloorDto {

    UUID id;
    String dormitoryName;
    Integer floorNumber;
    Integer numberOfRooms;
}
