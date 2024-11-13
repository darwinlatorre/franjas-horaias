package co.edu.unicauca.asae.taller_2.asignatura.application.ports;

import co.edu.unicauca.asae.taller_2.asignatura.domain.Asignatura;

public interface AsignaturaRepositoryPort {
    public Asignatura crear(Asignatura asignatura);

    public Asignatura encontrarPorID(Long ID);
}
