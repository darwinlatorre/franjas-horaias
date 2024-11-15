package co.edu.unicauca.asae.taller_2.users.application.ports;

import java.util.List;

import co.edu.unicauca.asae.taller_2.users.domain.models.Administrativo;

public interface AdministrativoRepositoryPort {

    Administrativo crear(Administrativo administrativo);

    Administrativo encontrarPorId(Long id);

    List<Administrativo> listarTodos();

    void eliminarPorId(Long id);
}
