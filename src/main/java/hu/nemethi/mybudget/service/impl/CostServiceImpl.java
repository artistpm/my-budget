package hu.nemethi.mybudget.service.impl;

import hu.nemethi.mybudget.dto.CostDto;
import hu.nemethi.mybudget.entity.Cost;
import hu.nemethi.mybudget.entity.Resources;
import hu.nemethi.mybudget.entity.User;
import hu.nemethi.mybudget.mapping.CostMapper;
import hu.nemethi.mybudget.repository.CostRepository;
import hu.nemethi.mybudget.repository.UserRepository;
import hu.nemethi.mybudget.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CostServiceImpl implements CostService<CostDto> {

    private CostRepository costRepository;
    private UserRepository userRepository;
    private CostMapper costMapper;

    @Autowired
    private ParameterEncryptorServiceImpl parameterEncryptorService;

    public CostServiceImpl(CostRepository costRepository, UserRepository userRepository, CostMapper costMapper) {
        this.costRepository = costRepository;
        this.userRepository = userRepository;
        this.costMapper = costMapper;
    }

    @Override
    public CostDto create(CostDto costDto) {
        Optional<User> user = userRepository.findById(costDto.getUserId());

        Cost cost = costMapper.mapDtoToEntity(costDto);
        cost.setUser(user.get());

        return costMapper.mapEntityToDto(costRepository.save(cost));
    }

    @Override
    public void delete(String id) throws SQLException {
        costRepository.deleteById(parameterEncryptorService.decrypt(id));
    }

    @Override
    public CostDto modify(CostDto costDto) {
        return costMapper.mapEntityToDto(costRepository.save(costMapper.mapDtoToEntity(costDto)));
    }

    @Override
    public List<CostDto> listAllByUserId(UUID userId) {
        List<Cost> list = costRepository.findAllCostsByUserId(userId);
        List<CostDto> costDtos = new ArrayList<>();
        list.forEach(item -> {
            costDtos.add(costMapper.mapEntityToDto(item));
        });

        return costDtos;
    }

    @Override
    public void deleteAllByUserId(UUID userId) {
        costRepository.deleteCostsByUserId(userId);
    }

    @Override
    public List<CostDto> findAllByUserId(UUID userId) {
        return null;
    }

    @Override
    public List<CostDto> findAllByUserIdInMonth(UUID userId, Month month) {
        return null;
    }

    @Override
    public List<CostDto> findAllByUserIdInPeriod(UUID userId, Resources period) {
        return null;
    }

    @Override
    public List<CostDto> findAllByUserIdAndCostName(UUID userId, String costName) {
        return null;
    }

    @Override
    public List<CostDto> findAllByUserIdAndPayed(UUID userId) {
        return null;
    }

    @Override
    public List<CostDto> findAllByUserIdAndNotPayed(UUID userId) {
        return null;
    }

    @Override
    public List<CostDto> findAllByUserIdAndCostValueInMonth(UUID userId, Double value, Month month) {
        return null;
    }

    @Override
    public List<CostDto> findAllByUserIdAndCostValueRangeAndInMonth(UUID userId, Double lowerValue, Double higherValue, Month month) {
        return null;
    }
}
