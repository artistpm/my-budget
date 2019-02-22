package hu.nemethi.mybudget.mapping;

import hu.nemethi.mybudget.dto.PlanDto;
import hu.nemethi.mybudget.entity.Plan;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface PlanMapper {

    Plan mapDtoToEntity(PlanDto planDto);

    PlanDto mapEntityToDto(Plan plan);
}
