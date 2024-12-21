package com.maoziy.yurtify.controller;

import com.maoziy.yurtify.controller.request.CreateNewRoomRequest;
import com.maoziy.yurtify.controller.request.QueryRoomRequest;
import com.maoziy.yurtify.controller.response.BaseResponse;
import com.maoziy.yurtify.model.dto.CreateRoom;
import com.maoziy.yurtify.model.dto.RoomDto;
import com.maoziy.yurtify.model.mapper.RoomMapper;
import com.maoziy.yurtify.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/room")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService service;

    private static final RoomMapper ROOM_MAPPER = Mappers.getMapper(RoomMapper.class);


    @GetMapping
    public BaseResponse<List<RoomDto>> getAll() {
        return BaseResponse.success(service.getAll());
    }

    @GetMapping("/query")
    public BaseResponse<List<RoomDto>> getAllByDormIdAndFloorId(@RequestBody QueryRoomRequest request) {
        List<RoomDto> rooms = service.getAllByDormIdAndFloorId(request.getDormId(), request.getFloorId());
        return BaseResponse.success(rooms);
    }

    @PostMapping
    public BaseResponse<RoomDto> createNewRoom(@RequestBody CreateNewRoomRequest createNewRoom) {
        CreateRoom createRoom = ROOM_MAPPER.createNewRoomRequestToCreateNewRoom(createNewRoom);

        return BaseResponse.success(service.createNewRoom(createRoom));
    }

    @DeleteMapping("/{id}")
    public BaseResponse<String> deleteDormitory(@PathVariable UUID id) {
        return BaseResponse.success(service.deleteRoom(id));
    }
}
