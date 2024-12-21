package com.maoziy.yurtify.service.impl;

import com.maoziy.yurtify.model.dto.FloorDto;
import com.maoziy.yurtify.model.dto.FloorRoomDto;
import com.maoziy.yurtify.model.entity.FloorEntity;
import com.maoziy.yurtify.model.exception.NotFoundException;
import com.maoziy.yurtify.model.mapper.FloorMapper;
import com.maoziy.yurtify.repository.DormitoryRepository;
import com.maoziy.yurtify.repository.FloorRepository;
import com.maoziy.yurtify.service.FloorService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FloorServiceImpl implements FloorService {

    private DormitoryRepository dormitoryRepository;
    private final FloorRepository floorRepository;

    private static final FloorMapper FLOOR_MAPPER = Mappers.getMapper(FloorMapper.class);


    @Override
    public FloorDto setRoomNumber(FloorRoomDto dto) {
        FloorEntity entity = floorRepository.findById(dto.getFloorId())
                .orElseThrow(() -> new NotFoundException(dto.getFloorId().toString()));

        entity.setNumberOfRooms(dto.getNumberOfRooms());
        return FLOOR_MAPPER.entityToDto(floorRepository.save(entity));
    }

    @Override
    public List<FloorDto> getAll() {
        return floorRepository.findAll().stream().map(FLOOR_MAPPER::entityToDto).toList();
    }

    @Override
    public List<FloorDto> getAllDormId(UUID id) {
        return floorRepository.findAllByDormitoryEntity_Id(id).stream().map(FLOOR_MAPPER::entityToDto).toList();
    }
}
