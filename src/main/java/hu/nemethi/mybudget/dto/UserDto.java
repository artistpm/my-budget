package hu.nemethi.mybudget.dto;

import hu.nemethi.mybudget.enums.Authority;
import hu.nemethi.mybudget.validation.annotations.Present;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {

    @NotNull
    private UUID userId;

    @NotBlank
    @Email
    @Size(max = 1024)
    private String username;

    @NotNull
    private Authority authority;

    @NotBlank
    @Size(max = 4096)
    private String pwrd;

    @NotNull
    @Present
    private LocalDateTime loginDate;

    private LocalDateTime created;

}
