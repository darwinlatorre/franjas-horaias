package co.edu.unicauca.asae.taller_2.docente.application.ports;

import co.edu.unicauca.asae.taller_2.docente.domain.Docente;

public interface DocenteRepositoryPort {
    public Docente crear(Docente docente);

    public Docente encontrarPorId(Long ID);

    public void eliminarPorId(Long ID);

    public boolean encontrarDocentePorPersonaId(Long personaID);
}
