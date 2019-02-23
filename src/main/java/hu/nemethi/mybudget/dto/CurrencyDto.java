package hu.nemethi.mybudget.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CurrencyDto {

    @NotNull
    private Integer currencyId;

    @NotBlank
    @Size(max = 8)
    private String currencyName;

    private boolean isDefault;

    private LocalDateTime created;
}
