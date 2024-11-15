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
    @Override
    public EspacioFisico crear(EspacioFisico espacioFisico) {
        EspacioFisicoEntity espacioFisicoEntity = modelMapper.map(espacioFisico, EspacioFisicoEntity.class);
        espacioFisicoRepository.save(espacioFisicoEntity);
        return modelMapper.map(espacioFisicoEntity, EspacioFisico.class);
    }

    @Override
    public EspacioFisico encontrarPorId(Long id) {
        EspacioFisicoEntity espacioFisico = espacioFisicoRepository.findById(id).orElse(null);
        return espacioFisico != null ? modelMapper.map(espacioFisico, EspacioFisico.class) : null;
    }

    @Transactional
    @Override
    public List<EspacioFisico> listarPorKeyword(String nombre, int capacidadMinima) {
        List<EspacioFisicoEntity> espacioFisicoEntities = espacioFisicoRepository
                .findByNombreIgnoreCaseStartingWithAndCapacidadGreaterThanEqualOrderByNombreAsc(nombre,
                        capacidadMinima);

        return espacioFisicoEntities.stream()
                .map(entity -> modelMapper.map(entity, EspacioFisico.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<EspacioFisico> listarTodos() {
        List<EspacioFisicoEntity> espacioFisicoEntities = espacioFisicoRepository.findAll();
        return espacioFisicoEntities.stream()
                .map(entity -> modelMapper.map(entity, EspacioFisico.class))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void eliminarPorId(Long id) {
        espacioFisicoRepository.deleteById(id);
    }
}
