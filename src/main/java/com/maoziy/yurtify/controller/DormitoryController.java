package com.maoziy.yurtify.controller;

import com.fasterxml.jackson.databind.JsonSerializable;
import com.maoziy.yurtify.controller.request.CreateNewDormitoryRequest;
import com.maoziy.yurtify.controller.request.UpdateDormitoryRequest;
import com.maoziy.yurtify.controller.response.BaseResponse;
import com.maoziy.yurtify.model.dto.DormitoryDto;
import com.maoziy.yurtify.model.dto.UpdateDormitory;
import com.maoziy.yurtify.model.mapper.DormitoryMapper;
import com.maoziy.yurtify.service.DormitoryService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/dormitory")
@RequiredArgsConstructor
public class DormitoryController {

    private final DormitoryService service;

    private static final DormitoryMapper MAPPER = Mappers.getMapper(DormitoryMapper.class);

    @GetMapping
    public BaseResponse<List<DormitoryDto>> getAll() {
        List<DormitoryDto> dormitories = service.getAll();

        return BaseResponse.success(dormitories);
    }

    @PostMapping
    public BaseResponse<DormitoryDto> createNewDormitory(@RequestBody CreateNewDormitoryRequest request) {
        DormitoryDto dormitoryDto = MAPPER.createRequestToDto(request);

        return BaseResponse.success(service.createNewDormitory(dormitoryDto));
    }

    @PutMapping("/{id}")
    public BaseResponse<DormitoryDto> updateDormitory(@PathVariable UUID id,@RequestBody UpdateDormitoryRequest request) {
        UpdateDormitory updateDormitory = MAPPER.updateRequestToUpdateDormitory(request);

        return BaseResponse.success(service.updateDormitory(id,updateDormitory));
    }

    //todo: burada sorun var, silmiyor !!
    @DeleteMapping("/{id}")
    public BaseResponse<String> deleteDormitory(@PathVariable UUID id) {
        return BaseResponse.success(service.deleteDormitory(id));
    }
}
