package co.edu.unicauca.asae.taller_2.franja_horaria.application.ports;

import java.time.LocalTime;
import java.util.List;

import co.edu.unicauca.asae.taller_2.franja_horaria.domain.FranjaHoraria;

public interface FranjaHorariaRepositoryPort {

    FranjaHoraria crear(FranjaHoraria franjaHoraria);

    List<FranjaHoraria> buscarPorDocente(Long idDocente);

    List<FranjaHoraria> listar();

    List<FranjaHoraria> listarPorDocente(Long id);

    boolean isEspacioFisicoOcupado(String dia, LocalTime horaInicio, LocalTime horaFin, Long espacioFisicoId);

    boolean isDocenteOcupado(String dia, LocalTime horaInicio, LocalTime horaFin, Long docenteId);

    void eliminarPorId(Long id);
}
