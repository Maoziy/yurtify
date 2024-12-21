package com.maoziy.yurtify.controller.request;


import lombok.Value;

@Value
public class UpdateDormitoryRequest {
    String name;
    Integer roomCapacity;
    Integer totalCapacity;
    Integer numberRegistered;
    Integer floor;
    Integer dormType;
}
