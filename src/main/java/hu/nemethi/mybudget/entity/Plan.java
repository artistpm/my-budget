package hu.nemethi.mybudget.entity;

import hu.nemethi.mybudget.enums.PlanType;
import hu.nemethi.mybudget.interfaces.ParameterEncryption;
import lombok.*;

import javax.persistence.*;
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
@Table(name="plan")
@ParameterEncryption(name = "Plan")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne
    private User user;

    @NotBlank
    @Size(max = 100)
    private String planName;

    @NotNull
    private LocalDate planDeadline;

    @NotNull
    private Double planAmount;

    @NotNull
    private PlanType planType;

    @OneToOne
    private Currency currency;

    @Size(max = 1024)
    private String description;

    @Column(name = "created", columnDefinition = "DATE default CURRENT_TIMESTAMP")
    private LocalDateTime created;

}
