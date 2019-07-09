package br.org.fiergs.legalconstitution.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LegalConstitution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
