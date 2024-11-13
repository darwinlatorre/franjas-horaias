package co.edu.unicauca.asae.taller_2.docente.infrastructure.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepository extends JpaRepository<DocenteEntity, Long> {

    Optional<DocenteEntity> findByPersona_Id(Long personaId);
}
