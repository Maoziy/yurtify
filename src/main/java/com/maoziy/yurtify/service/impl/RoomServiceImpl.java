package com.maoziy.yurtify.service.impl;

import com.maoziy.yurtify.model.dto.CreateRoom;
import com.maoziy.yurtify.model.dto.RoomDto;
import com.maoziy.yurtify.model.entity.DormitoryEntity;
import com.maoziy.yurtify.model.entity.FloorEntity;
import com.maoziy.yurtify.model.entity.RoomEntity;
import com.maoziy.yurtify.model.exception.NotFoundException;
import com.maoziy.yurtify.model.mapper.RoomMapper;
import com.maoziy.yurtify.repository.DormitoryRepository;
import com.maoziy.yurtify.repository.FloorRepository;
import com.maoziy.yurtify.repository.RoomRepository;
import com.maoziy.yurtify.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository repository;
    private final DormitoryRepository dormitoryRepository;
    private final FloorRepository floorRepository;

    private static final RoomMapper ROOM_MAPPER = Mappers.getMapper(RoomMapper.class);

    @Override
    public List<RoomDto> getAll() {
        return repository.findAll().stream().map(ROOM_MAPPER::entityToDto).toList();
    }

    @Override
    public List<RoomDto> getAllByDormIdAndFloorId(UUID dormId, UUID floorId) {
        List<RoomEntity> rooms = repository.findAllByDormId_IdAndFloorId_Id(dormId, floorId);
        return rooms.stream().map(ROOM_MAPPER::entityToDto).toList();
    }

    @Override
    public RoomDto createNewRoom(CreateRoom createRoom) {
        DormitoryEntity dormitoryEntity = dormitoryRepository.findById(createRoom.getDormId())
                .orElseThrow(() -> new NotFoundException(createRoom.getDormId().toString()));

        FloorEntity floorEntity = floorRepository.findById(createRoom.getFloorId())
                .orElseThrow(() -> new NotFoundException(createRoom.getDormId().toString()));

        RoomEntity roomEntity = RoomEntity.builder()
                .capacity(createRoom.getCapacity())
                .roomName(dormitoryEntity.getName()+floorEntity.getFloorNumber()+ createRoom.getNumber())
                .build();

        roomEntity.setDormId(dormitoryEntity);
        roomEntity.setFloorId(floorEntity);

        return ROOM_MAPPER.entityToDto(repository.save(roomEntity));

    }

    @Override
    public String deleteRoom(UUID id) {
        repository.deleteById(id);

        return "Record was deleted";
    }
}
