package co.edu.unicauca.asae.taller_2.oficina.infrastructure.persistence;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.taller_2.oficina.application.ports.OficinaRepositoryPort;
import co.edu.unicauca.asae.taller_2.oficina.domain.Oficina;
import jakarta.transaction.Transactional;

@Repository
public class OficinaRepositoryAdapter implements OficinaRepositoryPort {

    @Autowired
    OficinaRepository oficinaRepository;

    @Autowired
    ModelMapper modelMapper;

    @Transactional
    public Oficina crear(Oficina oficina) {
        OficinaEntity oficinaEntity = modelMapper.map(oficina, OficinaEntity.class);
        oficinaRepository.save(oficinaEntity);
        return modelMapper.map(oficinaEntity, Oficina.class);
    }

    public Oficina encontrarPorNombre(String Nombre) {
        OficinaEntity oficinaEntity = oficinaRepository.findByNombre(Nombre).orElse(null);
        if (oficinaEntity != null) {
            return modelMapper.map(oficinaEntity, Oficina.class);
        }
        return null;
    }

}
