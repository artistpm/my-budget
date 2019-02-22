package hu.nemethi.mybudget.service;

import hu.nemethi.mybudget.dto.PlanDto;
import hu.nemethi.mybudget.enums.PlanType;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface PlanService <T> extends GenericService<PlanDto> {

    List<T> findAllByUserIdAndPlanDeadline(UUID userId, LocalDate deadline);

    T findByUserIdAndPlanName(UUID userId, String planName);

    List<T> findAllByUserIdAndPlanType(UUID userId, PlanType planType);

    T findByUserIdAndPlanAmount(UUID userId, Double planAmount);

    List<T> findByUserIdAndPlanAmountRange(UUID userId, Double lowPlanAmount, Double highPlanAmount);
}
