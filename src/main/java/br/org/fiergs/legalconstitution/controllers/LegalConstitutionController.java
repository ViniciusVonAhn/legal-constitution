package br.org.fiergs.legalconstitution.controllers;

import br.org.fiergs.legalconstitution.entities.LegalConstitution;
import br.org.fiergs.legalconstitution.services.LegalConstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/legal-constitution")
public class LegalConstitutionController {

    @Autowired
    private LegalConstitutionService legalConstitutionService;

    @GetMapping
    public List<LegalConstitution> list(){
        return legalConstitutionService.list();
    }

    @GetMapping("/{description}")
    public Optional<LegalConstitution> listByDescription(@PathVariable("description")  String description){
        return legalConstitutionService.findByDescription(description);
    }

    @PostMapping
    public LegalConstitution save(@RequestBody @Valid LegalConstitution legalConstitution){
        return legalConstitutionService.save(legalConstitution);
    }

    @PutMapping
    public LegalConstitution edit(@RequestBody @Valid LegalConstitution legalConstitution){
        return legalConstitutionService.edit(legalConstitution);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        legalConstitutionService.delete(id);
    }
}
