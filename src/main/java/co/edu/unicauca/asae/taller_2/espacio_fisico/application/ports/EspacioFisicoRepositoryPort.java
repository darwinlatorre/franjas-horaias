package co.edu.unicauca.asae.taller_2.espacio_fisico.application.ports;

import java.util.List;

import co.edu.unicauca.asae.taller_2.espacio_fisico.domain.EspacioFisico;

public interface EspacioFisicoRepositoryPort {

    public EspacioFisico crear(EspacioFisico espacioFisico);

    public EspacioFisico encontrarPorID(Long ID);

    public List<EspacioFisico> listarPorKeyword(String nombre, int capacidadMinima);
}
