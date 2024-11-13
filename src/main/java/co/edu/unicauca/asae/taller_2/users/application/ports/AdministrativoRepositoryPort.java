package co.edu.unicauca.asae.taller_2.users.application.ports;

import co.edu.unicauca.asae.taller_2.users.domain.models.Administrativo;

public interface AdministrativoRepositoryPort {
    public Administrativo crear(Administrativo administrativo);

    public Administrativo encontrarPorId(Long id);
}
