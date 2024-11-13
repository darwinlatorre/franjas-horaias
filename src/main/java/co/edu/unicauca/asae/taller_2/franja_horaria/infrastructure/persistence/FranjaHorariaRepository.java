package co.edu.unicauca.asae.taller_2.franja_horaria.infrastructure.persistence;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FranjaHorariaRepository extends JpaRepository<FranjaHorariaEntity, Long> {

        List<FranjaHorariaEntity> findByCurso_Docentes_Id(Long docenteId);

        @Query("SELECT CASE WHEN COUNT(franjaHoraria) > 0 THEN true ELSE false END " +
                        "FROM FranjaHorariaEntity franjaHoraria " +
                        "JOIN franjaHoraria.espacioFisico espacioFisico " +
                        "WHERE espacioFisico.id = :espacioFisicoId " +
                        "AND franjaHoraria.dia = :dia " +
                        "AND franjaHoraria.horaInicio <= :horaFin " +
                        "AND franjaHoraria.horaFin >= :horaInicio")
        boolean isEspacioFisicoOcupado(@Param("dia") String dia,
                        @Param("horaInicio") LocalTime horaInicio,
                        @Param("horaFin") LocalTime horaFin,
                        @Param("espacioFisicoId") Long espacioFisicoId);

        @Query(value = "SELECT CASE WHEN COUNT(franjaHoraria) > 0 THEN true ELSE false END " +
                        "FROM franja_horaria franjaHoraria " +
                        "JOIN curso c ON franjaHoraria.curso_id = c.id " +
                        "JOIN curso_docente cd ON c.id = cd.curso_id " +
                        "JOIN docente d ON cd.docente_id = d.id " +
                        "WHERE d.id = :docenteId " +
                        "AND franjaHoraria.dia = :dia " +
                        "AND franjaHoraria.hora_inicio <= :horaFin " +
                        "AND franjaHoraria.hora_fin >= :horaInicio", nativeQuery = true)

        boolean isDocenteOcupado(@Param("dia") String dia,
                        @Param("horaInicio") LocalTime horaInicio,
                        @Param("horaFin") LocalTime horaFin,
                        @Param("docenteId") Long docenteId);

}
