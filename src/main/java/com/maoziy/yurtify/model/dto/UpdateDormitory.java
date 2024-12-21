package com.maoziy.yurtify.model.dto;

import lombok.Value;

@Value
public class UpdateDormitory {
     String name;
     Integer roomCapacity;
     Integer totalCapacity;
     Integer numberRegistered;
     Integer floor;
     Integer dormType;
}
