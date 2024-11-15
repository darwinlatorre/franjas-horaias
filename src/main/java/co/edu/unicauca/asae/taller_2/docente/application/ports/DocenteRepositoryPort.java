package co.edu.unicauca.asae.taller_2.docente.application.ports;

import java.util.List;

import co.edu.unicauca.asae.taller_2.docente.domain.Docente;

public interface DocenteRepositoryPort {
    Docente crear(Docente docente);

    Docente encontrarPorId(Long id);

    void eliminarPorId(Long id);

    boolean encontrarDocentePorPersonaId(Long id);

    List<Docente> listarTodos();
}
