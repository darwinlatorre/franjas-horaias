package co.edu.unicauca.asae.taller_2.asignatura.infrastructure.persistence;

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

    public Asignatura crear(Asignatura asignatura) {
        AsignaturaEntity asignaturaEntity = modelMapper.map(asignatura, AsignaturaEntity.class);
        asignaturaEntity = asignaturaRepository.save(asignaturaEntity);
        return modelMapper.map(asignaturaEntity, Asignatura.class);
    }

    public Asignatura encontrarPorID(Long ID) {
        AsignaturaEntity asignaturaEntity = asignaturaRepository.findById(ID).orElse(null);
        if (asignaturaEntity != null) {
            return modelMapper.map(asignaturaEntity, Asignatura.class);
        }
        return null;
    }

}
