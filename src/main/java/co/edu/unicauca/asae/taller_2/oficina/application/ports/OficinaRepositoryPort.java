package co.edu.unicauca.asae.taller_2.oficina.application.ports;

import java.util.List;

import co.edu.unicauca.asae.taller_2.oficina.domain.Oficina;

public interface OficinaRepositoryPort {

    Oficina crear(Oficina oficina);

    Oficina encontrarPorNombre(String nombre);

    Oficina encontrarPorId(Long id);

    List<Oficina> listarTodas();

    void eliminarPorId(Long id);
}
