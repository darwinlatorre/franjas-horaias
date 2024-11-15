package co.edu.unicauca.asae.taller_2.curso.application.ports;

import java.util.List;

import co.edu.unicauca.asae.taller_2.curso.domain.Curso;

public interface CursoRepositoryPort {

    Curso crear(Curso curso);

    Curso encontrarPorId(Long id);

    void eliminarPorId(Long id);

    List<Curso> listarTodos();
}
