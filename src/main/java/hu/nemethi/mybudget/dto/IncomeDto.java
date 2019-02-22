package hu.nemethi.mybudget.dto;

import hu.nemethi.mybudget.entity.Currency;
import hu.nemethi.mybudget.entity.Resources;
import lombok.*;

import javax.persistence.OneToOne;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class IncomeDto {

    @NotNull
    private Integer incomeId;

    @NotNull
    private UUID userId;

    @NotBlank
    @Size(max = 100)
    private String incomeName;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private Double incomeValue;

    @NotBlank
    @Size(max = 100)
    private String incomeLabel;

    private Currency currency;

    @FutureOrPresent
    private LocalDate receiptDate;

    @NotNull
    private Resources receivePeriod;

    @NotNull
    private boolean received;

    @Size(max = 1024)
    private String description;

    private LocalDateTime created;
}
