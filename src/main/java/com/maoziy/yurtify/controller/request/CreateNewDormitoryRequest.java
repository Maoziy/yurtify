package com.maoziy.yurtify.controller.request;

import lombok.Data;

@Data
public class CreateNewDormitoryRequest {

    private String name;
    private Integer roomCapacity;
    private Integer totalCapacity;
    private Integer numberRegistered;
    private Integer floor;
    private Integer dormType;

    private CreateCommunicationRequest communication;
}
