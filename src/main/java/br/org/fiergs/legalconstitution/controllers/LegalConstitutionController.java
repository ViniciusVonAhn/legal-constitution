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

    @GetMapping("/{name}")
    public Optional<List<LegalConstitution>> listByName(@PathVariable("name")  String name){
        return legalConstitutionService.findByName(name);
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
