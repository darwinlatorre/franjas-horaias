package co.edu.unicauca.asae.taller_2.asignatura.application.ports;

import java.util.List;

import co.edu.unicauca.asae.taller_2.asignatura.domain.Asignatura;

public interface AsignaturaRepositoryPort {
    Asignatura crear(Asignatura asignatura);

    Asignatura encontrarPorId(Long id);

    List<Asignatura> listarTodos();

    void eliminarPorId(Long id);
}
