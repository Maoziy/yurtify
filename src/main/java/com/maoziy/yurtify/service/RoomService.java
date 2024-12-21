package com.maoziy.yurtify.service;

import com.maoziy.yurtify.model.dto.CreateRoom;
import com.maoziy.yurtify.model.dto.RoomDto;

import java.util.List;
import java.util.UUID;

public interface RoomService {


    List<RoomDto> getAll();

    List<RoomDto> getAllByDormIdAndFloorId(UUID dormId, UUID floorId);

    RoomDto createNewRoom(CreateRoom createRoom);

    String deleteRoom(UUID id);
}
