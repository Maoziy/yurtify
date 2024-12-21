package com.maoziy.yurtify.controller;

import com.maoziy.yurtify.controller.response.BaseResponse;
import com.maoziy.yurtify.model.dto.FloorDto;
import com.maoziy.yurtify.model.dto.FloorRoomDto;
import com.maoziy.yurtify.service.FloorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/floor")
@RequiredArgsConstructor
public class FloorController {

    private final FloorService service;

    @GetMapping("/{id}")
    public BaseResponse<List<FloorDto>> getAllByDormId(@PathVariable UUID id){
        return BaseResponse.success(service.getAllDormId(id));
    }

    @GetMapping
    public BaseResponse<List<FloorDto>> getAll(){
        return BaseResponse.success(service.getAll());
    }

    @PostMapping
    public BaseResponse<FloorDto> setRoomNumber(@RequestBody FloorRoomDto dto){
        return BaseResponse.success(service.setRoomNumber(dto));
    }
}
