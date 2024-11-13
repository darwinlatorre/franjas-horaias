package co.edu.unicauca.asae.taller_2.espacio_fisico.infrastructure.persistence;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.taller_2.espacio_fisico.application.ports.EspacioFisicoRepositoryPort;
import co.edu.unicauca.asae.taller_2.espacio_fisico.domain.EspacioFisico;
import jakarta.transaction.Transactional;

@Repository
public class EspacioFisicoRepositoryAdapter implements EspacioFisicoRepositoryPort {

    @Autowired
    private EspacioFisicoRepository espacioFisicoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public EspacioFisico crear(EspacioFisico espacioFisico) {
        EspacioFisicoEntity espacioFisicoEntity = modelMapper.map(espacioFisico, EspacioFisicoEntity.class);
        espacioFisicoRepository.save(espacioFisicoEntity);
        return modelMapper.map(espacioFisicoEntity, EspacioFisico.class);
    }

    @Transactional
    public List<EspacioFisico> listarPorKeyword(String nombre, int capacidadMinima) {
        List<EspacioFisicoEntity> espacioFisicoEntities = espacioFisicoRepository
                .findByNombreIgnoreCaseStartingWithAndCapacidadGreaterThanEqualOrderByNombreAsc(nombre,
                        capacidadMinima);

        return espacioFisicoEntities.stream()
                .map(EspacioFisicoEntity -> modelMapper.map(EspacioFisicoEntity, EspacioFisico.class))
                .collect(Collectors.toList());

    }

    public EspacioFisico encontrarPorID(Long ID) {
        EspacioFisicoEntity espacioFisico = espacioFisicoRepository.findById(ID).orElse(null);
        return modelMapper.map(espacioFisico, EspacioFisico.class);
    }
}
