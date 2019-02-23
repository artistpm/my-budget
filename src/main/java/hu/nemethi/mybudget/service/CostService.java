package hu.nemethi.mybudget.service;

import hu.nemethi.mybudget.dto.CostDto;
import hu.nemethi.mybudget.entity.Resources;

import java.time.Month;
import java.util.List;
import java.util.UUID;

public interface CostService<T> extends GenericService<CostDto> {

    List<T> findAllByUserId(UUID userId);

    List<T> findAllByUserIdInMonth(UUID userId, Month month);

    List<T> findAllByUserIdInPeriod(UUID userId, Resources period);

    List<T> findAllByUserIdAndCostName(UUID userId, String costName);

    List<T> findAllByUserIdAndPayed(UUID userId);

    List<T> findAllByUserIdAndNotPayed(UUID userId);

    List<T> findAllByUserIdAndCostValueInMonth(UUID userId, Double amount, Month month);

    List<T> findAllByUserIdAndCostValueRangeAndInMonth(UUID userId, Double lowAmount, Double highAmount, Month month);
}
