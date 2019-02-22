package hu.nemethi.mybudget.mapping;

import hu.nemethi.mybudget.dto.LanguageDto;
import hu.nemethi.mybudget.entity.Language;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface LanguageMapper {

    Language mapDtoToEntity(LanguageDto languageDto);

    LanguageDto mapEntityToDto(Language language);
}
