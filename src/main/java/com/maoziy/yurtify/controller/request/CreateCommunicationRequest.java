package com.maoziy.yurtify.controller.request;

import lombok.Data;

@Data
public class CreateCommunicationRequest {

    private String email;
    private String phone;
    private String city;
}
