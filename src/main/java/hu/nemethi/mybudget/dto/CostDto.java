package hu.nemethi.mybudget.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import hu.nemethi.mybudget.entity.Currency;
import hu.nemethi.mybudget.entity.Resources;
import hu.nemethi.mybudget.interfaces.ParameterEncryptible;
import hu.nemethi.mybudget.interfaces.ParameterEncryption;
import lombok.*;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = {"costName", "costValue"})
@ParameterEncryption(name = "Cost")
public class CostDto implements ParameterEncryptible {

    @NotNull
    private Integer costId;

    @NotNull
    private UUID userId;

    @NotBlank
    @Size(max = 100)
    private String costName;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private Double costValue;

    @NotBlank
    @Size(max = 100)
    private String costLabel;

    @NotNull
    private Currency currency;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDate paymentDeadline;

    @NotNull
    private boolean payed;

    // Monthly, yearly, weekly, half in a year, quater in a year
    @NotNull
    private Resources paymentPeriod;

    private String otherIdentifier;

    @Size(max = 1024)
    private String description;
}
