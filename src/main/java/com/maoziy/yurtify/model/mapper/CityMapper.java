package com.maoziy.yurtify.model.mapper;

import com.maoziy.yurtify.controller.response.CityResponse;
import com.maoziy.yurtify.model.dto.CityDto;
import com.maoziy.yurtify.model.entity.CityEntity;
import org.mapstruct.Mapper;

//todo : BaseMapper yazilabilir
@Mapper
public interface CityMapper {

    CityDto mapToDto(CityEntity entity);
    CityResponse mapToResponse(CityDto dto);
}
