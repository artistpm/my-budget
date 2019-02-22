package hu.nemethi.mybudget.mapping;

import hu.nemethi.mybudget.dto.CurrencyDto;
import hu.nemethi.mybudget.entity.Currency;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface CurrencyMapper {

    Currency mapDtoToEntity(CurrencyDto currencyDto);

    CurrencyDto mapEntityToDto(Currency currency);

}
