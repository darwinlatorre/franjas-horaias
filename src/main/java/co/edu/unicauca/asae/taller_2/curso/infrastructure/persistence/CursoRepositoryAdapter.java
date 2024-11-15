package co.edu.unicauca.asae.taller_2.curso.infrastructure.persistence;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.taller_2.curso.application.ports.CursoRepositoryPort;
import co.edu.unicauca.asae.taller_2.curso.domain.Curso;
import jakarta.transaction.Transactional;

@Repository
public class CursoRepositoryAdapter implements CursoRepositoryPort {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public Curso crear(Curso curso) {
        CursoEntity cursoEntity = modelMapper.map(curso, CursoEntity.class);
        CursoEntity guardado = cursoRepository.save(cursoEntity);
        return modelMapper.map(guardado, Curso.class);
    }

    @Override
    public Curso encontrarPorId(Long id) {
        CursoEntity cursoEntity = cursoRepository.findById(id).orElse(null);
        return cursoEntity != null ? modelMapper.map(cursoEntity, Curso.class) : null;
    }

    @Transactional
    @Override
    public void eliminarPorId(Long id) {
        cursoRepository.deleteById(id);
    }

    @Override
    public List<Curso> listarTodos() {
        List<CursoEntity> cursoEntities = cursoRepository.findAll();
        return cursoEntities.stream()
                .map(entity -> modelMapper.map(entity, Curso.class))
                .collect(Collectors.toList());
    }
}
