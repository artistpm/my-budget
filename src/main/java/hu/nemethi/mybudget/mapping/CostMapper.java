package hu.nemethi.mybudget.mapping;

import hu.nemethi.mybudget.dto.CostDto;
import hu.nemethi.mybudget.entity.Cost;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CostMapper {


    @Mappings({
        @Mapping(source = "costId", target = "id"),
        @Mapping(source = "userId", target = "user.id")
    })
    Cost mapDtoToEntity(CostDto costDto);

    @Mappings({
            @Mapping(source = "id", target = "costId"),
            @Mapping(source = "user.id", target = "userId")
    })
    CostDto mapEntityToDto(Cost cost);

}
