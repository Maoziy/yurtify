package com.maoziy.yurtify.model.mapper;

import com.maoziy.yurtify.model.dto.DormDetailDto;
import com.maoziy.yurtify.model.entity.DormDetailEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface DormDetailMapper {
    DormDetailEntity dtoToEntity(DormDetailDto dormDetailDto);

    DormDetailDto entityToDto(DormDetailEntity saved);

    void updateEntityFromDto(DormDetailDto dormDetailDto, @MappingTarget DormDetailEntity entity);
}
