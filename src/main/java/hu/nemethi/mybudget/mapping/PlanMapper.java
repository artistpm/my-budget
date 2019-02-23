package hu.nemethi.mybudget.mapping;

import hu.nemethi.mybudget.dto.PlanDto;
import hu.nemethi.mybudget.entity.Plan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel="spring")
public interface PlanMapper {

    @Mappings({
            @Mapping(source = "planId", target = "id"),
            @Mapping(source = "userId", target = "user.id")
    })
    Plan mapDtoToEntity(PlanDto planDto);

    @Mappings({
            @Mapping(source = "id", target = "planId"),
            @Mapping(source = "user.id", target = "userId")
    })
    PlanDto mapEntityToDto(Plan plan);
}
