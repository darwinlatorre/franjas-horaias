package co.edu.unicauca.asae.taller_2.espacio_fisico.application.ports;

import java.util.List;

import co.edu.unicauca.asae.taller_2.espacio_fisico.domain.EspacioFisico;

public interface EspacioFisicoRepositoryPort {

    EspacioFisico crear(EspacioFisico espacioFisico);

    EspacioFisico encontrarPorId(Long id);

    List<EspacioFisico> listarPorKeyword(String nombre, int capacidadMinima);

    List<EspacioFisico> listarTodos();

    void eliminarPorId(Long id);
}
