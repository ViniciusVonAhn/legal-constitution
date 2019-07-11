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
        List<LegalConstitution> legalConstitutionsExists = legalConstitutionRepository.findAll();
        if(legalConstitutionsExists.isEmpty()){
            throw new RuntimeException("Nenhuma Constituição juridica encontrada");
        }
        return legalConstitutionsExists;
    }

    public Optional<List<LegalConstitution>> findByName(String name){
        Optional<List<LegalConstitution>> nameExists = legalConstitutionRepository.findByNameContainingIgnoreCase(name);
        if(nameExists.isPresent()) {
            return legalConstitutionRepository.findByNameContainingIgnoreCase(name);
        }else{
            throw new RuntimeException("Nenhum nome encontrado");
        }
    }

    public LegalConstitution save(LegalConstitution legalConstitution) {
        Optional<LegalConstitution> nameOrCodeExists = legalConstitutionRepository.
                findByCodeOrNameContainingIgnoreCase(legalConstitution.getCode(), legalConstitution.getName());
        if(nameOrCodeExists.isPresent()){
            throw new RuntimeException("Nome ou código já está cadastrado");
        }

        return this.legalConstitutionRepository.save(legalConstitution);
    }

    public LegalConstitution edit(LegalConstitution legalConstitution) {
        Optional<LegalConstitution> optionalLegalConstitution = legalConstitutionRepository.
                findOneByNameIgnoreCaseOrCodeAndIdNot(legalConstitution.getName(), legalConstitution.getCode(), legalConstitution.getId());
        if(optionalLegalConstitution.isEmpty()){
            return legalConstitutionRepository.save(legalConstitution);
        }else {
            throw new RuntimeException("Nome ou código já está cadastrado");
        }
    }

    public void delete(Long id) {
        this.legalConstitutionRepository.deleteById(id);
    }
}
