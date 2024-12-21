package com.maoziy.yurtify.service.impl;

import com.maoziy.yurtify.model.dto.DormDetailDto;
import com.maoziy.yurtify.model.entity.DormDetailEntity;
import com.maoziy.yurtify.model.entity.DormitoryEntity;
import com.maoziy.yurtify.model.exception.NotFoundException;
import com.maoziy.yurtify.model.mapper.DormDetailMapper;
import com.maoziy.yurtify.repository.DormDetailRepository;
import com.maoziy.yurtify.repository.DormitoryRepository;
import com.maoziy.yurtify.service.DormDetailService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DormDetailServiceImpl implements DormDetailService {

    private final DormDetailRepository repository;
    private final DormitoryRepository dormitoryRepository;

    private static final DormDetailMapper MAPPER = Mappers.getMapper(DormDetailMapper.class);

    @Override
    public DormDetailDto createNew(UUID id, DormDetailDto dormDetailDto) {
        DormitoryEntity dormitoryEntity = dormitoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id.toString()));

        dormitoryEntity.setDormDetailEntity(MAPPER.dtoToEntity(dormDetailDto));

        DormitoryEntity saved = dormitoryRepository.save(dormitoryEntity);

        return MAPPER.entityToDto(saved.getDormDetailEntity());
    }

    @Override
    public String delete(UUID id) {
        repository.deleteById(id);

        return "Record was deleted";
    }

    @Override
    public DormDetailDto update(UUID id, DormDetailDto dormDetailDto) {
        DormDetailEntity entity = repository.findById(id).orElseThrow(() -> new NotFoundException(id.toString()));
        MAPPER.updateEntityFromDto(dormDetailDto, entity);

        return MAPPER.entityToDto(repository.save(entity));
    }

    @Override
    public DormDetailDto getByDormitoryId(UUID id) {
        DormitoryEntity dormitoryEntity = dormitoryRepository.findById(id).orElseThrow(() -> new NotFoundException(id.toString()));

        return MAPPER.entityToDto(dormitoryEntity.getDormDetailEntity());
    }
}
