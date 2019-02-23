package hu.nemethi.mybudget.service.impl;

import hu.nemethi.mybudget.dto.IncomeDto;
import hu.nemethi.mybudget.entity.Income;
import hu.nemethi.mybudget.entity.Resources;
import hu.nemethi.mybudget.mapping.IncomeMapper;
import hu.nemethi.mybudget.repository.IncomeRepository;
import hu.nemethi.mybudget.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class IncomeServiceImpl implements IncomeService<IncomeDto> {

    private IncomeRepository incomeRepository;
    private IncomeMapper incomeMapper;

    @Autowired
    private ParameterEncryptorServiceImpl parameterEncryptorService;

    public IncomeServiceImpl(IncomeRepository incomeRepository, IncomeMapper incomeMapper) {
        this.incomeRepository = incomeRepository;
        this.incomeMapper = incomeMapper;
    }

    @Override
    public IncomeDto create(IncomeDto incomeDto) {
        return incomeMapper.mapEntityToDto(incomeRepository.save(incomeMapper.mapDtoToEntity(incomeDto)));
    }

    @Override
    public void delete(String id) {
        incomeRepository.deleteById(parameterEncryptorService.decrypt(id));
    }

    @Override
    public IncomeDto modify(IncomeDto incomeDto) {
        return this.create(incomeDto);
    }

    @Override
    public List<IncomeDto> listAllByUserId(UUID userId) {
        List<Income> incomes = incomeRepository.findAllIncomesByUserId(userId);
        List<IncomeDto> incomeDtos = new ArrayList<>();
        incomes.forEach( income ->  {
            incomeDtos.add(incomeMapper.mapEntityToDto(income));
        });
        return incomeDtos;
    }

    @Override
    public void deleteAllByUserId(UUID userId) {
        incomeRepository.deleteAllByUserId(userId);
    }

    @Override
    public List<IncomeDto> findALlByUserIdAndLabel(UUID userId, String label) {
        return null;
    }

    @Override
    public List<IncomeDto> findAllByUserIdAndValue(UUID userId, Double amount) {
        return null;
    }

    @Override
    public List<IncomeDto> findAllByUserIdAndReceiptDate(UUID userId, LocalDate receiptDate) {
        return null;
    }

    @Override
    public List<IncomeDto> findAllByUserIdAndReceived(UUID userId, Boolean received) {
        return null;
    }

    @Override
    public List<IncomeDto> findAllByUserIdAndReceiptPeriod(UUID userId, Resources period) {
        return null;
    }
}
