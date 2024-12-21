package com.maoziy.yurtify.model.mapper;

import com.maoziy.yurtify.controller.request.CreateNewDormitoryRequest;
import com.maoziy.yurtify.controller.request.UpdateDormitoryRequest;
import com.maoziy.yurtify.model.dto.DormDetailDto;
import com.maoziy.yurtify.model.dto.DormitoryDto;
import com.maoziy.yurtify.model.dto.UpdateDormitory;
import com.maoziy.yurtify.model.entity.DormDetailEntity;
import com.maoziy.yurtify.model.entity.DormitoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface DormitoryMapper {

    DormitoryDto createRequestToDto(CreateNewDormitoryRequest request);

    @Mapping(source ="communication.city" ,target = "communication.city.name")
    @Mapping(source ="dto.dormDetailDto.detailText" ,target = "dormDetailEntity.detailText")
    @Mapping(source ="dto.dormDetailDto.facilityText" ,target = "dormDetailEntity.facilityText")
    DormitoryEntity dtoToEntity(DormitoryDto dto);

    @Mapping(target ="communication.city" ,source = "communication.city.name")
    DormitoryDto entityToDto(DormitoryEntity saved);

    UpdateDormitory updateRequestToUpdateDormitory(UpdateDormitoryRequest request);

    DormitoryEntity updateDormitoryToEntity(UpdateDormitory updateDormitory);

    void updateEntityFromDto(UpdateDormitory updateDormitory, @MappingTarget DormitoryEntity entity);
}
