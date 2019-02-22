package hu.nemethi.mybudget.mapping;

import hu.nemethi.mybudget.dto.ResourcesDto;
import hu.nemethi.mybudget.entity.Resources;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface ResourcesMapper {

    Resources mapDtoToEntity(ResourcesDto resourcesDto);

    ResourcesDto mapEntityToDto(Resources resources);
}
