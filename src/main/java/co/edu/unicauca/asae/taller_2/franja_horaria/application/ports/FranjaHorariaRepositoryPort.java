package co.edu.unicauca.asae.taller_2.franja_horaria.application.ports;

import java.time.LocalTime;
import java.util.List;

import co.edu.unicauca.asae.taller_2.franja_horaria.domain.FranjaHoraria;

public interface FranjaHorariaRepositoryPort {

    public FranjaHoraria crear(FranjaHoraria franjaHoraria);

    public List<FranjaHoraria> buscarPorDocente(Long idDocente);

    public List<FranjaHoraria> listar();

    public List<FranjaHoraria> listarPorDocente(Long id);

    public boolean isEspacioFisicoOcupado(String dia, LocalTime horaInicio, LocalTime horaFin, Long espacioFisicoId);

    public boolean isDocenteOcupado(String dia, LocalTime horaInicio, LocalTime horaFin, Long docenteId);
}
