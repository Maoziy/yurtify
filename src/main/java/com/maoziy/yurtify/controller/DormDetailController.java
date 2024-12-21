package com.maoziy.yurtify.controller;

import com.maoziy.yurtify.controller.response.BaseResponse;
import com.maoziy.yurtify.model.dto.DormDetailDto;
import com.maoziy.yurtify.service.DormDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/dormdet")
@RequiredArgsConstructor
public class DormDetailController {

    private final DormDetailService service;

    @PostMapping("/{dormitoryId}")
    public BaseResponse<DormDetailDto> createNewDormDetail(@PathVariable UUID id, @RequestBody DormDetailDto dormDetailDto) {
        DormDetailDto dto = service.createNew(id,dormDetailDto);

        return BaseResponse.success(dto);
    }

    @GetMapping("/{dormitoryId}")
    public BaseResponse<DormDetailDto> getDetail(@PathVariable UUID dormitoryId) {
        DormDetailDto dto = service.getByDormitoryId(dormitoryId);

        return BaseResponse.success(dto);
    }


}
