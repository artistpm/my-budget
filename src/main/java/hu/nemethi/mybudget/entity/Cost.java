package hu.nemethi.mybudget.entity;

import hu.nemethi.mybudget.interfaces.ParameterEncryption;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "cost")
@ParameterEncryption(name = "Cost")
public class Cost {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne
    private User user;

    @NotBlank
    @Size(max = 100)
    private String costName;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private Double costValue;

    @NotBlank
    @Size(max = 100)
    private String costLabel;

    @OneToOne
    private Currency currency;

    @NotNull
    private LocalDate paymentDeadline;

    @NotNull
    private boolean payed;

    @OneToOne
    private Resources paymentPeriod;

    private String otherIdentifier;

    @Size(max = 1024)
    private String description;

    @Column(name = "created", columnDefinition = "DATE default CURRENT_TIMESTAMP")
    private LocalDateTime created;
}
