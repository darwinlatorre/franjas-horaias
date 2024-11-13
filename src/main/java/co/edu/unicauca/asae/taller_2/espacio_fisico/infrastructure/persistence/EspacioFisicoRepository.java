package co.edu.unicauca.asae.taller_2.espacio_fisico.infrastructure.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspacioFisicoRepository extends JpaRepository<EspacioFisicoEntity, Long> {
    List<EspacioFisicoEntity> findByNombreIgnoreCaseStartingWithAndCapacidadGreaterThanEqualOrderByNombreAsc(
            String nombre, int capacidadMinima);
}
