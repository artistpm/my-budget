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
@Table(name="language")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotBlank
    @Size(max = 100)
    @Column(name = "name")
    private String languageName;

    @Column(name = "created", columnDefinition = "DATE default CURRENT_TIMESTAMP")
    private LocalDateTime created;

}
