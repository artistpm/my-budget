package hu.nemethi.mybudget.entity.parameterencryption;

import hu.nemethi.mybudget.entity.Income;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class IncomeParameterEncryption {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer penId;

    @OneToOne
    private Income incomeId;

    @NotNull
    @Column(name = "encrypted_data")
    private String encryptedData;

    @Column(name = "created", columnDefinition = "DATE default CURRENT_TIMESTAMP")
    private LocalDateTime created;

    @Column(name = "obsolete", columnDefinition = "DATE default CURRENT_TIMESTAMP")
    private LocalDateTime obsolete;
}
