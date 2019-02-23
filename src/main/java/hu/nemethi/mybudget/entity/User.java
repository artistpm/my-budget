package hu.nemethi.mybudget.entity;

import hu.nemethi.mybudget.enums.Authority;
import hu.nemethi.mybudget.validation.annotations.Present;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @NotBlank
    @Size(max = 1024)
    @Email
    private String username;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "authority", columnDefinition = "VARCHAR(16) default 'USER'")
    private Authority authority;

    @NotBlank
    @Size(max = 4096)
    private String pwrd;

    @NotNull
    @Present
    private LocalDateTime loginDate;

    @Column(name = "created", columnDefinition = "DATE default CURRENT_TIMESTAMP")
    private LocalDateTime created;

}
