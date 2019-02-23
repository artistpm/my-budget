package hu.nemethi.mybudget.dto;

import hu.nemethi.mybudget.entity.Language;
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
public class ResourcesDto {

    @NotNull
    private Integer resourceId;

    @NotBlank
    @Size(max = 100)
    private String resourceKey;

    @NotBlank
    @Size(max = 100)
    private String resourceName;

    @NotNull
    private Language language;

    private LocalDateTime created;

}
