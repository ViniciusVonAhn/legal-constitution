package br.org.fiergs.legalconstitution.repositories;

import br.org.fiergs.legalconstitution.entities.LegalConstitution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LegalConstitutionRepository extends JpaRepository<LegalConstitution, Long> {

    Optional<List<LegalConstitution>> findByNameContainingIgnoreCase(String name);

    @Query("select o from LegalConstitution o where (upper(name)  = upper(?1) or code = ?2) and id <> ?3")
    Optional<LegalConstitution> findOneByNameIgnoreCaseOrCodeAndIdNot(String name, String code, Long id);

    Optional<LegalConstitution> findByCodeOrNameContainingIgnoreCase(String code, String name);
}
