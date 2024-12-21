package com.maoziy.yurtify.controller;

import com.maoziy.yurtify.controller.response.BaseResponse;
import com.maoziy.yurtify.controller.response.CityResponse;
import com.maoziy.yurtify.model.mapper.CityMapper;
import com.maoziy.yurtify.service.CityService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/city")
@RequiredArgsConstructor
public class CityController {

      private final CityService service;

    private static final CityMapper cityMapper = Mappers.getMapper(CityMapper.class);


    @GetMapping
    public BaseResponse<List<CityResponse>> getAll() {
        List<CityResponse> cities = service.getAll().stream().map(cityMapper::mapToResponse).toList();

        return BaseResponse.success(cities);
    }

}
