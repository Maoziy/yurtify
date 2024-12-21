package com.maoziy.yurtify.service.impl;

import com.maoziy.yurtify.model.entity.CityEntity;
import com.maoziy.yurtify.model.mapper.CityMapper;
import com.maoziy.yurtify.model.dto.CityDto;
import com.maoziy.yurtify.repository.CityRepository;
import com.maoziy.yurtify.service.CityService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository repository;
    private static final CityMapper cityMapper = Mappers.getMapper(CityMapper.class);

    @Override
    public List<CityDto> getAll() {
        List<CityEntity> all = repository.findAll();
        return all
                .stream().map(cityMapper::mapToDto).toList();
    }
}
