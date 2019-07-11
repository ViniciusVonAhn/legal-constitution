package br.org.fiergs.legalconstitution.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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

    @Size(max = 20, message = "Chave deve ser menor que 21 caracteres")
    private String key;

    @NotEmpty(message = "Código é obrigatório")
    @Size(max = 11, message = "Maximo de 11 caracteres")
    private String code;

    @NotEmpty(message = "Nome é obrigatório")
    @Size(max = 20, message = "Maximo de 20 caracteres")
    private String name;

    private boolean active = true;
}
