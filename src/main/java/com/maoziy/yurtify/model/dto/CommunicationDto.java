package com.maoziy.yurtify.model.dto;

import lombok.Data;

@Data
public class CommunicationDto {

    //private UUID id; //todo: id vermeli miyiz ?
    private String email;
    private String phone;
    private String city;
}
