package hu.nemethi.mybudget.service.impl;

import hu.nemethi.mybudget.dto.CurrencyDto;
import hu.nemethi.mybudget.entity.Currency;
import hu.nemethi.mybudget.mapping.CurrencyMapper;
import hu.nemethi.mybudget.repository.CurrencyRepository;
import hu.nemethi.mybudget.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CurrencyServiceImpl implements CurrencyService<CurrencyDto> {

    private CurrencyRepository currencyRepository;
    private CurrencyMapper currencyMapper;

    @Autowired
    private ParameterEncryptorServiceImpl parameterEncryptorService;

    public CurrencyServiceImpl(CurrencyRepository currencyRepository, CurrencyMapper currencyMapper) {
        this.currencyRepository = currencyRepository;
        this.currencyMapper = currencyMapper;
    }

    @Override
    public CurrencyDto create(CurrencyDto currencyDto) {
        return currencyMapper.mapEntityToDto(currencyRepository.save(currencyMapper.mapDtoToEntity(currencyDto)));
    }

    /**
     *
     * @param id is parameter encrypted
     * @return
     */
    @Override
    public void delete(String id) {
        currencyRepository.deleteById(parameterEncryptorService.decrypt(id));
    }

    @Override
    public CurrencyDto modify(CurrencyDto currencyDto){
        return this.create(currencyDto);
    }

    @Override
    public List<CurrencyDto> listAllByUserId(UUID userId) {
        List<Currency> list = currencyRepository.findAllCurrenciesByUserId(userId);
        List<CurrencyDto> currencyDtos = new ArrayList<CurrencyDto>();
        list.forEach(item -> {
            currencyDtos.add(currencyMapper.mapEntityToDto(item));
        });

        return currencyDtos;
    }

    @Override
    public void deleteAllByUserId(UUID userId) throws SQLException {
        throw new UnsupportedOperationException("");
    }

}
