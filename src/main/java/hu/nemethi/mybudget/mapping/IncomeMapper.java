package hu.nemethi.mybudget.mapping;

import hu.nemethi.mybudget.dto.IncomeDto;
import hu.nemethi.mybudget.entity.Income;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface IncomeMapper {

    Income mapDtoToEntity(IncomeDto incomeDto);

    IncomeDto mapEntityToDto(Income income);

}
