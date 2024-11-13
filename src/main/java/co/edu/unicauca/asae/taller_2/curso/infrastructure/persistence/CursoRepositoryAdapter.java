package co.edu.unicauca.asae.taller_2.curso.infrastructure.persistence;

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
    ModelMapper modelMapper;

    @Transactional
    public Curso crear(Curso curso) {
        CursoEntity cursoEntity = modelMapper.map(curso, CursoEntity.class);
        CursoEntity guardado = cursoRepository.save(cursoEntity);
        return modelMapper.map(guardado, Curso.class);
    }

    public Curso encontrarPorId(Long ID) {
        CursoEntity cursoEntity = cursoRepository.findById(ID).orElse(null);
        return modelMapper.map(cursoEntity, Curso.class);
    }

    @Transactional
    public void eliminarPorId(Long ID) {
        cursoRepository.deleteById(ID);
    }
}
