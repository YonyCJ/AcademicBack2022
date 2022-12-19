package com.academic.app.academicback.mapper;

import com.academic.app.academicback.dto.PeriodDto;
import com.academic.app.academicback.entity.PeriodEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PeriodMapper {

    PeriodMapper INSTANCE = Mappers.getMapper( PeriodMapper.class );

//    @Mapping(source = "description", target = "descripcion")
    PeriodDto periodoEntityToPeridoDto (PeriodEntity request);

    List<PeriodDto> periodoEntityListToPeridoDtoList (List<PeriodEntity> request);



}
