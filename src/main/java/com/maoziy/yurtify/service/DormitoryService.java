package com.maoziy.yurtify.service;

import com.maoziy.yurtify.model.dto.DormitoryDto;
import com.maoziy.yurtify.model.dto.UpdateDormitory;

import java.util.List;
import java.util.UUID;

public interface DormitoryService {

    List<DormitoryDto> getAll();

    DormitoryDto createNewDormitory(DormitoryDto dormitoryDto);

    DormitoryDto updateDormitory(UUID id, UpdateDormitory updateDormitory);

    String deleteDormitory(UUID id);
}
