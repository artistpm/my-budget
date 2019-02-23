package hu.nemethi.mybudget.dto;

import hu.nemethi.mybudget.entity.Currency;
import hu.nemethi.mybudget.enums.PlanType;
import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PlanDto {

    @NotNull
    private Integer planId;

    @NotNull
    private UUID userId;

    @NotBlank
    @Size(max = 100)
    private String planName;

    @NotNull
    @Future
    private LocalDate planDeadline;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private Double planAmount;

    @NotNull
    private PlanType planType;

    private Currency currency;

    @Size(max = 1024)
    private String description;

    private LocalDateTime created;
}
