package com.maoziy.yurtify.service;

import com.maoziy.yurtify.model.dto.DormDetailDto;

import java.util.UUID;

public interface DormDetailService {

    DormDetailDto createNew(UUID id, DormDetailDto dormDetailDto);

    String delete(UUID id);

    DormDetailDto update(UUID id, DormDetailDto dormDetailDto);

    DormDetailDto getByDormitoryId(UUID id);
}
