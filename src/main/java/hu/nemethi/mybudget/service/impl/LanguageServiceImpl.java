package hu.nemethi.mybudget.service.impl;

import hu.nemethi.mybudget.dto.LanguageDto;
import hu.nemethi.mybudget.entity.Language;
import hu.nemethi.mybudget.mapping.LanguageMapper;
import hu.nemethi.mybudget.repository.LanguageRepository;
import hu.nemethi.mybudget.service.LanguageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService<LanguageDto> {

    private LanguageRepository languageRepository;
    private LanguageMapper languageMapper;

    public LanguageServiceImpl(LanguageRepository languageRepository, LanguageMapper languageMapper) {
        this.languageRepository = languageRepository;
        this.languageMapper = languageMapper;
    }

    @Override
    public LanguageDto create(LanguageDto languageDto) {
        Language language = languageMapper.mapDtoToEntity(languageDto);
        return languageMapper.mapEntityToDto(languageRepository.save(language));
    }

    @Override
    public void delete(LanguageDto languageDto) {
        Language language = languageMapper.mapDtoToEntity(languageDto);
        languageRepository.delete(language);
    }

    @Override
    public List<LanguageDto> listAll() {
        List<Language> languageList = languageRepository.findAll();
        List<LanguageDto> languageDtoList = new ArrayList<>();
        languageList.forEach( language ->  {
            languageDtoList.add(languageMapper.mapEntityToDto(language));
        });
        return languageDtoList;
    }


}
