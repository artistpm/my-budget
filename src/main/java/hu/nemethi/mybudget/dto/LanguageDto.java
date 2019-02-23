package hu.nemethi.mybudget.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class LanguageDto {

    @NotNull
    private Integer languageId;

    @NotBlank
    @Size(max = 100)
    private String languageName;

    private LocalDateTime created;

}
