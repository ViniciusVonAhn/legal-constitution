package br.org.fiergs.legalconstitution.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CAD_LEGALCONSTITUTION")
@SequenceGenerator(name = "seqCad_legalconstitution", sequenceName = "SEQCAD_LEGALCONSTITUTION", allocationSize = 1)
public class LegalConstitution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqCad_legalconstitution")
    private Long id;

    @NotNull(message = "Código é obrigatório")
    @Size(max = 20, message = "Maximo de 20 caracteres")
    private String code;

    @NotNull(message = "Descrição é obrigatório")
    @Size(max = 20, message = "Maximo de 20 caracteres")
    private String description;

    private String icm;

    private boolean status;
}
