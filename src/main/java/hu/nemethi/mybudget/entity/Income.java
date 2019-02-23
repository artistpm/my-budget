package hu.nemethi.mybudget.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "income")
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne
    private User user;

    @NotBlank
    @Size(max = 100)
    private String incomeName;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private Double incomeValue;

    @NotBlank
    @Size(max = 100)
    private String incomeLabel;

    @OneToOne
    private Currency currency;

    @FutureOrPresent
    private LocalDate receiptDate;

    @OneToOne
    private Resources receivePeriod;

    @NotNull
    private boolean received;

    @Size(max = 1024)
    private String description;

    @Column(name = "created", columnDefinition = "DATE default CURRENT_TIMESTAMP")
    private LocalDateTime created;

}
