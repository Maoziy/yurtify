package com.maoziy.yurtify.model.dto;

import lombok.Data;

@Data
public class DormitoryDto {

    private String id;
    private String name;
    private Integer roomCapacity;
    private Integer totalCapacity;
    private Integer numberRegistered;
    private Integer floor;
    private Integer dormType;
    private DormDetailDto dormDetailDto;

    private CommunicationDto communication;

}
