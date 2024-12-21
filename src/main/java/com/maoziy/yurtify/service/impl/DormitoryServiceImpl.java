package com.maoziy.yurtify.service.impl;

import com.maoziy.yurtify.model.dto.DormitoryDto;
import com.maoziy.yurtify.model.dto.UpdateDormitory;
import com.maoziy.yurtify.model.entity.CityEntity;
import com.maoziy.yurtify.model.entity.CommunicationEntity;
import com.maoziy.yurtify.model.entity.DormitoryEntity;
import com.maoziy.yurtify.model.exception.AlreadyExistsException;
import com.maoziy.yurtify.model.exception.NotFoundException;
import com.maoziy.yurtify.model.mapper.CommunicationMapper;
import com.maoziy.yurtify.model.mapper.DormitoryMapper;
import com.maoziy.yurtify.repository.CityRepository;
import com.maoziy.yurtify.repository.CommunicationRepository;
import com.maoziy.yurtify.repository.DormitoryRepository;
import com.maoziy.yurtify.service.DormitoryService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DormitoryServiceImpl implements DormitoryService {

    private final DormitoryRepository repository;
    private final CommunicationRepository communicationRepository;
    private final CityRepository cityRepository;

    private static final DormitoryMapper MAPPER = Mappers.getMapper(DormitoryMapper.class);
    private static final CommunicationMapper MAPPER_COMMUNICATION_MAPPER = Mappers.getMapper(CommunicationMapper.class);

    @Override
    public List<DormitoryDto> getAll() {
        return repository.findAll().stream().map(MAPPER::entityToDto).toList();
    }

    @Override
    public DormitoryDto createNewDormitory(DormitoryDto dormitoryDto) {
        DormitoryEntity entity = MAPPER.dtoToEntity(dormitoryDto);

        if (repository.findByName(dormitoryDto.getName()).isPresent()){
            throw new AlreadyExistsException(dormitoryDto.getName());
        }

        CommunicationEntity communicationEntity = MAPPER_COMMUNICATION_MAPPER.dtoToEntity(dormitoryDto.getCommunication());
        CityEntity cityEntity = cityRepository.findByName(dormitoryDto.getCommunication().getCity())
                .orElseThrow(() -> new NotFoundException(dormitoryDto.getCommunication().getCity()));

        communicationEntity.setCity(cityEntity);
        entity.setCommunication(communicationEntity);

        return MAPPER.entityToDto(repository.save(entity));
    }

    @Override
    public DormitoryDto updateDormitory(UUID id, UpdateDormitory updateDormitory) {
        DormitoryEntity entity = repository.findById(id).orElseThrow(() -> new NotFoundException(id.toString()));

        MAPPER.updateEntityFromDto(updateDormitory,entity);

        return MAPPER.entityToDto(repository.save(entity));
    }

    @Override
    public String deleteDormitory(UUID id) {
        repository.deleteById(id);

        return "Record was deleted";
    }
}
