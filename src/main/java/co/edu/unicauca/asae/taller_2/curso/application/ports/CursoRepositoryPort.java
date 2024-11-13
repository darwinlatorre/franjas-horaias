package co.edu.unicauca.asae.taller_2.curso.application.ports;

import co.edu.unicauca.asae.taller_2.curso.domain.Curso;

public interface CursoRepositoryPort {

    public Curso crear(Curso curso);

    public Curso encontrarPorId(Long ID);

    public void eliminarPorId(Long ID);
}
