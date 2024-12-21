package com.maoziy.yurtify.model.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CommunicationDto {

    private UUID id;
    private String email;
    private String phone;
    private String city;
}
