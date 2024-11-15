package co.edu.unicauca.asae.taller_2.oficina.infrastructure.persistence;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.taller_2.oficina.application.ports.OficinaRepositoryPort;
import co.edu.unicauca.asae.taller_2.oficina.domain.Oficina;
import jakarta.transaction.Transactional;

@Repository
public class OficinaRepositoryAdapter implements OficinaRepositoryPort {

    @Autowired
    private OficinaRepository oficinaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public Oficina crear(Oficina oficina) {
        OficinaEntity oficinaEntity = modelMapper.map(oficina, OficinaEntity.class);
        oficinaRepository.save(oficinaEntity);
        return modelMapper.map(oficinaEntity, Oficina.class);
    }

    @Override
    public Oficina encontrarPorNombre(String nombre) {
        OficinaEntity oficinaEntity = oficinaRepository.findByNombre(nombre).orElse(null);
        return oficinaEntity != null ? modelMapper.map(oficinaEntity, Oficina.class) : null;
    }

    @Override
    public Oficina encontrarPorId(Long id) {
        OficinaEntity oficinaEntity = oficinaRepository.findById(id).orElse(null);
        return oficinaEntity != null ? modelMapper.map(oficinaEntity, Oficina.class) : null;
    }

    @Override
    public List<Oficina> listarTodas() {
        List<OficinaEntity> oficinaEntities = oficinaRepository.findAll();
        return oficinaEntities.stream()
                .map(entity -> modelMapper.map(entity, Oficina.class))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void eliminarPorId(Long id) {
        oficinaRepository.deleteById(id);
    }
}
