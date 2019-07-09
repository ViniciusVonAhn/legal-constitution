package br.org.fiergs.legalconstitution.repositories;

import br.org.fiergs.legalconstitution.entities.LegalConstitution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LegalConstitutionRepository extends JpaRepository<LegalConstitution, Long> {

    Optional<LegalConstitution> findByDescriptionContainingIgnoreCase(String description);

    //Optional<LegalConstitution> findByCodeOrDescriptionContainingIgnoreCaseAndIdIsNot(Long code, String description, Long id);

    @Query("select o from LegalConstitution o where (upper(description)  = upper(?1) or code = ?2) and id <> ?3")
    Optional<LegalConstitution> findOneByDescriptionIgnoreCaseOrCodeAndIdNot(String description, String code, Long id);

    Optional<LegalConstitution> findByCodeOrDescriptionContainingIgnoreCase(String code, String description);
}
