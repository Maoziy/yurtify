package com.maoziy.yurtify.model.mapper;

import com.maoziy.yurtify.controller.request.CreateNewRoomRequest;
import com.maoziy.yurtify.model.dto.CreateRoom;
import com.maoziy.yurtify.model.dto.RoomDto;
import com.maoziy.yurtify.model.entity.RoomEntity;
import org.mapstruct.Mapper;

@Mapper
public interface RoomMapper {


    RoomDto entityToDto(RoomEntity all);

    CreateRoom createNewRoomRequestToCreateNewRoom(CreateNewRoomRequest request);
}
