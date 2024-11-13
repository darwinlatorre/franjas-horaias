package co.edu.unicauca.asae.taller_2.users.infrastructure.persistence.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.taller_2.users.infrastructure.persistence.entity.PersonaEntity;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {
}
