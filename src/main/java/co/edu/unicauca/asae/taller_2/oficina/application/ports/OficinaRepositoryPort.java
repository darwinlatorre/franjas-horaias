package co.edu.unicauca.asae.taller_2.oficina.application.ports;

import co.edu.unicauca.asae.taller_2.oficina.domain.Oficina;

public interface OficinaRepositoryPort {

    public Oficina crear(Oficina oficina);

    public Oficina encontrarPorNombre(String nombre);
}
