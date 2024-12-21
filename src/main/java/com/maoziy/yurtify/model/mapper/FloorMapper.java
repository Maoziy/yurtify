package com.maoziy.yurtify.model.mapper;

import com.maoziy.yurtify.model.dto.FloorDto;
import com.maoziy.yurtify.model.entity.FloorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface FloorMapper {

    @Mapping(source = "dormitoryEntity.name",target = "dormitoryName")
    FloorDto entityToDto(FloorEntity entity);
}
