package hu.nemethi.mybudget.service.impl;

import hu.nemethi.mybudget.dto.PlanDto;
import hu.nemethi.mybudget.entity.Plan;
import hu.nemethi.mybudget.enums.PlanType;
import hu.nemethi.mybudget.mapping.PlanMapper;
import hu.nemethi.mybudget.repository.PlanRepository;
import hu.nemethi.mybudget.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PlanServiceImpl implements PlanService<PlanDto>{

    private PlanRepository planRepository;
    private PlanMapper planMapper;

    @Autowired
    private ParameterEncryptorServiceImpl parameterEncryptorService;

    public PlanServiceImpl(PlanRepository planRepository, PlanMapper planMapper) {
        this.planRepository = planRepository;
        this.planMapper = planMapper;
    }

    @Override
    public PlanDto create(PlanDto planDto) {
        Plan plan = planMapper.mapDtoToEntity(planDto);
        return planMapper.mapEntityToDto(planRepository.save(plan));
    }

    /**
     *
     * @param id is parameter encrypted
     * @return
     */
    @Override
    public void delete(String id) {
        planRepository.deleteById(parameterEncryptorService.decrypt(id));
    }

    @Override
    public PlanDto modify(PlanDto planDto) {
        return this.create(planDto);
    }

    @Override
    public List<PlanDto> listAllByUserId(UUID userId) {
        List<PlanDto> planDtoList = new ArrayList<>();
        List<Plan> planList = planRepository.findAllByUserId(userId);
        planList.forEach( plan ->  {
            planDtoList.add(planMapper.mapEntityToDto(plan));
        });
        return planDtoList;
    }

    @Override
    public void deleteAllByUserId(UUID userId) {
        planRepository.deleteAllByUserId(userId);
    }

    @Override
    public List<PlanDto> findAllByUserIdAndPlanDeadline(UUID userId, LocalDate deadline) {
        return null;
    }

    @Override
    public PlanDto findByUserIdAndPlanName(UUID userId, String planName) {
        return null;
    }

    @Override
    public List<PlanDto> findAllByUserIdAndPlanType(UUID userId, PlanType planType) {
        return null;
    }

    @Override
    public PlanDto findByUserIdAndPlanAmount(UUID userId, Double planAmount) {
        return null;
    }

    @Override
    public List<PlanDto> findByUserIdAndPlanAmountRange(UUID userId, Double lowPlanAmount, Double highPlanAmount) {
        return null;
    }
}
