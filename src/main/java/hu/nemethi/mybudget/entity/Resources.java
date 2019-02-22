package hu.nemethi.mybudget.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name="resources")
public class Resources {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotBlank
    @Size(max = 100)
    private String resourceKey;

    @NotBlank
    @Size(max = 100)
    private String resourceName;

    @OneToOne
    private Language language;

    @Column(name = "created", columnDefinition = "DATE default CURRENT_TIMESTAMP")
    private LocalDateTime created;
}
