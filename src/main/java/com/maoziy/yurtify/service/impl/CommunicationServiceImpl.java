package com.maoziy.yurtify.service.impl;

import com.maoziy.yurtify.model.dto.CommunicationDto;
import com.maoziy.yurtify.model.entity.CityEntity;
import com.maoziy.yurtify.model.entity.CommunicationEntity;
import com.maoziy.yurtify.model.exception.NotFoundException;
import com.maoziy.yurtify.model.mapper.CommunicationMapper;
import com.maoziy.yurtify.repository.CityRepository;
import com.maoziy.yurtify.repository.CommunicationRepository;
import com.maoziy.yurtify.service.CommunicationService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommunicationServiceImpl implements CommunicationService {

    private final CommunicationRepository repository;
    private final CityRepository cityRepository;
    private static final CommunicationMapper MAPPER = Mappers.getMapper(CommunicationMapper.class);

    @Override
    public List<CommunicationDto> getAll() {
        return repository.findAll().stream().map(MAPPER::entityToDto).toList();
    }

    @Override
    public CommunicationDto createNewCommunication(CommunicationDto communicationDto) {
        CommunicationEntity entity = MAPPER.dtoToEntity(communicationDto);
        String city = communicationDto.getCity();

        CityEntity cityEntity = cityRepository.findByName(city)
                .orElseThrow(() -> new NotFoundException(city));

        entity.setCity(cityEntity);
        return MAPPER.entityToDto(repository.save(entity));
    }

    @Override
    public CommunicationDto updateCommunication(UUID id, CommunicationDto communicationDto) {
        String cityName = communicationDto.getCity();
        CityEntity cityEntity = cityRepository.findByName(cityName).orElseThrow(() -> new NotFoundException(cityName));

        CommunicationEntity entity = repository.findById(id).orElseThrow(() -> new NotFoundException(id.toString()));

        MAPPER.updateEntityFromDto(communicationDto,entity);
        entity.setCity(cityEntity);

        return MAPPER.entityToDto(repository.save(entity));
    }

    @Override
    public CommunicationDto getById(UUID id) {
        CommunicationEntity entity = repository.findById(id).orElseThrow(() -> new NotFoundException(id.toString()));

        return MAPPER.entityToDto(entity);
    }
}
