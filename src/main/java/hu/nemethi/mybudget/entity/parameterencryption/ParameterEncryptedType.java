package hu.nemethi.mybudget.entity.parameterencryption;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table
public class ParameterEncryptedType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer penId;

    // the id of the delegator type (e.g. Cost.id
    @Column(name = "original_id")
    @NotNull
    private Integer encryptedTypeId;

    @Column(name = "delegator")
    @NotBlank
    private String delegatorName;

    // the encrypted string
    @Column(name = "encrypted_data")
    @NotNull
    private String encryptedData;

    @Column(name = "created", columnDefinition = "DATE default CURRENT_TIMESTAMP")
    private LocalDateTime created;

}
