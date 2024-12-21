package com.maoziy.yurtify.model.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class DormDetailDto {

    private UUID uuid;
    private String detailText;
    private String facilityText;
}
