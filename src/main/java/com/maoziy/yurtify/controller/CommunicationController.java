package com.maoziy.yurtify.controller;

import com.maoziy.yurtify.controller.request.CreateCommunicationRequest;
import com.maoziy.yurtify.controller.request.UpdateCommunicationRequest;
import com.maoziy.yurtify.controller.response.BaseResponse;
import com.maoziy.yurtify.model.dto.CommunicationDto;
import com.maoziy.yurtify.model.mapper.CommunicationMapper;
import com.maoziy.yurtify.service.CommunicationService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/communication")
@RequiredArgsConstructor
public class CommunicationController {

    private final CommunicationService service;

    private static final CommunicationMapper MAPPER = Mappers.getMapper(CommunicationMapper.class);


    @GetMapping
    public BaseResponse<List<CommunicationDto>> getAll() {
        List<CommunicationDto> cities = service.getAll();

        return BaseResponse.success(cities);
    }

    @PostMapping
    public BaseResponse<CommunicationDto> createNewCommunication(@RequestBody CreateCommunicationRequest request) {
        CommunicationDto communicationDto = MAPPER.requestToDto(request);
        CommunicationDto savedRecord = service.createNewCommunication(communicationDto);

        return BaseResponse.success(savedRecord);
    }

    @PutMapping("/{id}")
    public BaseResponse<CommunicationDto> updateCommunication(@PathVariable UUID id, @RequestBody UpdateCommunicationRequest request) {
        CommunicationDto communicationDto = MAPPER.requestToDto(request);
        CommunicationDto savedRecord = service.updateCommunication(id,communicationDto);

        return BaseResponse.success(savedRecord);
    }

}
