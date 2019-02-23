package hu.nemethi.mybudget.entity.parameterencryption;

import hu.nemethi.mybudget.entity.Cost;
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
public class CostParameterEncryption {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer penId;

    @OneToOne
    private Cost costId;

    @Column(name = "encrypted_data")
    @NotNull
    private String encryptedData;

    @Column(name = "created", columnDefinition = "DATE default CURRENT_TIMESTAMP")
    private LocalDateTime created;

    @Column(name = "obsolete", columnDefinition = "DATE default CURRENT_TIMESTAMP")
    private LocalDateTime obsolete;
}
