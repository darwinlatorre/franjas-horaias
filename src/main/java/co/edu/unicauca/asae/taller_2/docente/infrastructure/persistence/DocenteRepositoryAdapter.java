package co.edu.unicauca.asae.taller_2.docente.infrastructure.persistence;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.taller_2.docente.application.ports.DocenteRepositoryPort;
import co.edu.unicauca.asae.taller_2.docente.domain.Docente;

@Repository
public class DocenteRepositoryAdapter implements DocenteRepositoryPort {

    @Autowired
    private DocenteRepository docenteRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Docente crear(Docente docente) {
        DocenteEntity docenteEntity = modelMapper.map(docente, DocenteEntity.class);
        DocenteEntity guardado = docenteRepository.save(docenteEntity);
        return modelMapper.map(guardado, Docente.class);
    }

    @Override
    public Docente encontrarPorId(Long id) {
        DocenteEntity docenteEntity = docenteRepository.findById(id).orElse(null);
        return docenteEntity != null ? modelMapper.map(docenteEntity, Docente.class) : null;
    }

    @Override
    public void eliminarPorId(Long id) {
        docenteRepository.deleteById(id);
    }

    @Override
    public boolean encontrarDocentePorPersonaId(Long id) {
        DocenteEntity docenteEntity = docenteRepository.findByPersona_Id(id).orElse(null);
        return docenteEntity != null;
    }

    @Override
    public List<Docente> listarTodos() {
        List<DocenteEntity> docenteEntities = docenteRepository.findAll();
        return docenteEntities.stream()
                .map(entity -> modelMapper.map(entity, Docente.class))
                .collect(Collectors.toList());
    }
}
