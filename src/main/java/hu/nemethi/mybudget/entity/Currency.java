package hu.nemethi.mybudget.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name="currency")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotBlank
    @Size(max = 8)
    @Column(name = "currency_name")
    private String currencyName;

    @Column(name = "is_default", columnDefinition = "boolean default FALSE")
    private boolean isDefault;

    @Column(name = "created", columnDefinition = "DATE default CURRENT_TIMESTAMP")
    private LocalDateTime created;
}
