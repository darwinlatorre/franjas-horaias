package co.edu.unicauca.asae.taller_2.oficina.infrastructure.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OficinaRepository extends JpaRepository<OficinaEntity, Long> {
    Optional<OficinaEntity> findByNombre(String Nombre);
}
