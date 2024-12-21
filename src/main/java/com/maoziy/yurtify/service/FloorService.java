package com.maoziy.yurtify.service;


import com.maoziy.yurtify.model.dto.FloorDto;
import com.maoziy.yurtify.model.dto.FloorRoomDto;
import com.maoziy.yurtify.repository.FloorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface FloorService {


    FloorDto setRoomNumber(FloorRoomDto dto);

    List<FloorDto> getAll();

    List<FloorDto> getAllDormId(UUID id);
}
