package com.maoziy.yurtify.service;


import com.maoziy.yurtify.model.dto.CommunicationDto;

import java.util.List;
import java.util.UUID;

public interface CommunicationService {

    List<CommunicationDto> getAll();

    CommunicationDto createNewCommunication(CommunicationDto communicationDto);

    CommunicationDto updateCommunication(UUID id, CommunicationDto communicationDto);

    CommunicationDto getById(UUID id);
}
