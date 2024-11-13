package co.edu.unicauca.asae.taller_2.docente.infrastructure.persistence;

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

    public Docente crear(Docente docente) {
        DocenteEntity docenteEntity = modelMapper.map(docente, DocenteEntity.class);
        DocenteEntity guardado = docenteRepository.save(docenteEntity);
        return modelMapper.map(guardado, Docente.class);
    }

    public Docente encontrarPorId(Long idDocente) {
        DocenteEntity docenteEntity = docenteRepository.findById(idDocente).orElse(null);
        return modelMapper.map(docenteEntity, Docente.class);
    }

    public void eliminarPorId(Long idDocente) {
        docenteRepository.deleteById(idDocente);
    }

    @Override
    public boolean encontrarDocentePorPersonaId(Long personaID) {
        DocenteEntity docenteEntity = docenteRepository.findByPersona_Id(personaID).orElse(null);
        if (docenteEntity == null) {
            return false;
        }
        return true;
    }

}
