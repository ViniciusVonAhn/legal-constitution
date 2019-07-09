package br.org.fiergs.legalconstitution.services;

import br.org.fiergs.legalconstitution.entities.LegalConstitution;
import br.org.fiergs.legalconstitution.repositories.LegalConstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LegalConstitutionService {

    @Autowired
    private LegalConstitutionRepository legalConstitutionRepository;

    public List<LegalConstitution> list(){
        return legalConstitutionRepository.findAll();
    }

    public Optional<LegalConstitution> findByDescription(String description){
        Optional<LegalConstitution> descriptionExists = legalConstitutionRepository.findByDescriptionContainingIgnoreCase(description);
        if(descriptionExists.isPresent() && descriptionExists != null) {
            return legalConstitutionRepository.findByDescriptionContainingIgnoreCase(description);
        }else{
            throw new RuntimeException("Nenhuma descrição encontrado");
        }
    }

    public LegalConstitution save(LegalConstitution legalConstitution) {
        Optional<LegalConstitution> descriptionOrCodeExists = legalConstitutionRepository.
                findByCodeOrDescriptionContainingIgnoreCase(legalConstitution.getCode(), legalConstitution.getDescription());
        if(descriptionOrCodeExists.isPresent()){
            throw new RuntimeException("Descrição ou códgio já está cadastrado");
        }

        return this.legalConstitutionRepository.save(legalConstitution);
    }

    public LegalConstitution edit(LegalConstitution legalConstitution) {
        Optional<LegalConstitution> optionalLegalConstitution = legalConstitutionRepository.
                findOneByDescriptionContainingIgnoreCaseOrCodeAndIdNot(legalConstitution.getDescription(), legalConstitution.getCode(), legalConstitution.getId());
        if(optionalLegalConstitution.isEmpty()){
            return legalConstitutionRepository.save(legalConstitution);
        }else {
            throw new RuntimeException("Descrição ou códgio já está cadastrado");
        }
    }

    public void delete(Long id) {
        this.legalConstitutionRepository.deleteById(id);
    }
}
