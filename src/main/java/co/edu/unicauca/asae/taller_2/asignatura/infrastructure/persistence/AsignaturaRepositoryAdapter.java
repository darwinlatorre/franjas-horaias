package co.edu.unicauca.asae.taller_2.asignatura.infrastructure.persistence;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.taller_2.asignatura.application.ports.AsignaturaRepositoryPort;
import co.edu.unicauca.asae.taller_2.asignatura.domain.Asignatura;

@Repository
public class AsignaturaRepositoryAdapter implements AsignaturaRepositoryPort {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Asignatura crear(Asignatura asignatura) {
        AsignaturaEntity asignaturaEntity = modelMapper.map(asignatura, AsignaturaEntity.class);
        asignaturaEntity = asignaturaRepository.save(asignaturaEntity);
        return modelMapper.map(asignaturaEntity, Asignatura.class);
    }

    @Override
    public Asignatura encontrarPorId(Long id) {
        AsignaturaEntity asignaturaEntity = asignaturaRepository.findById(id).orElse(null);
        return asignaturaEntity != null ? modelMapper.map(asignaturaEntity, Asignatura.class) : null;
    }

    @Override
    public List<Asignatura> listarTodos() {
        List<AsignaturaEntity> asignaturasEntities = asignaturaRepository.findAll();
        return asignaturasEntities.stream()
                .map(entity -> modelMapper.map(entity, Asignatura.class))
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarPorId(Long id) {
        asignaturaRepository.deleteById(id);
    }
}