package com.sim.myparserhtml.mapper;

import com.sim.myparserhtml.dto.ParserRequestDto;
import com.sim.myparserhtml.dto.ParserResponseDto;
import com.sim.myparserhtml.entity.Statistic;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatisticMapper {
    ParserResponseDto toDto(Statistic entity);
    Statistic toEntity(ParserRequestDto dto);
}
