package com.maoziy.yurtify.model.mapper;

import com.maoziy.yurtify.controller.request.CreateCommunicationRequest;
import com.maoziy.yurtify.model.dto.CommunicationDto;
import com.maoziy.yurtify.model.entity.CommunicationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface CommunicationMapper {

    @Mapping(source = "entity.city.name", target = "city")
    CommunicationDto entityToDto(CommunicationEntity entity);

    CommunicationDto requestToDto(CreateCommunicationRequest request);

    @Mapping(target = "city", ignore = true)
    CommunicationEntity dtoToEntity(CommunicationDto dto); //todo: city problem olabilir

    @Mapping(target = "city",ignore = true)
    @Mapping(target = "id",ignore = true)
    void updateEntityFromDto(CommunicationDto communicationDto, @MappingTarget CommunicationEntity entity);
}
