package hu.nemethi.mybudget.mapping;

import hu.nemethi.mybudget.dto.IncomeDto;
import hu.nemethi.mybudget.entity.Income;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel="spring")
public interface IncomeMapper {

    @Mappings({
            @Mapping(source = "incomeId", target = "id"),
            @Mapping(source = "userId", target = "user.id")
    })
    Income mapDtoToEntity(IncomeDto incomeDto);

    @Mappings({
            @Mapping(source = "id", target = "incomeId"),
            @Mapping(source = "user.id", target = "userId")
    })
    IncomeDto mapEntityToDto(Income income);

}
