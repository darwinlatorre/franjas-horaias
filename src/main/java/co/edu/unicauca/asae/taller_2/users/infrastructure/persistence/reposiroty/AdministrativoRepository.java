package co.edu.unicauca.asae.taller_2.users.infrastructure.persistence.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.taller_2.users.infrastructure.persistence.entity.AdministrativoEntity;

@Repository
public interface AdministrativoRepository extends JpaRepository<AdministrativoEntity, Long> {
}
