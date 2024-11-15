package co.edu.unicauca.asae.taller_2.users.infrastructure.persistence.adapters;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.taller_2.users.application.ports.AdministrativoRepositoryPort;
import co.edu.unicauca.asae.taller_2.users.domain.models.Administrativo;
import co.edu.unicauca.asae.taller_2.users.infrastructure.persistence.entity.AdministrativoEntity;
import co.edu.unicauca.asae.taller_2.users.infrastructure.persistence.reposiroty.AdministrativoRepository;

@Repository
public class AdministrativoRepositoryAdapter implements AdministrativoRepositoryPort {

    @Autowired
    private AdministrativoRepository administrativoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Administrativo crear(Administrativo administrativo) {
        AdministrativoEntity administrativoEntity = modelMapper.map(administrativo, AdministrativoEntity.class);
        administrativoEntity = administrativoRepository.save(administrativoEntity);
        return modelMapper.map(administrativoEntity, Administrativo.class);
    }

    @Override
    public Administrativo encontrarPorId(Long id) {
        AdministrativoEntity administrativoEntity = administrativoRepository.findById(id).orElse(null);
        return administrativoEntity != null ? modelMapper.map(administrativoEntity, Administrativo.class) : null;
    }

    @Override
    public List<Administrativo> listarTodos() {
        List<AdministrativoEntity> administrativoEntities = administrativoRepository.findAll();
        return administrativoEntities.stream()
                .map(entity -> modelMapper.map(entity, Administrativo.class))
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarPorId(Long id) {
        administrativoRepository.deleteById(id);
    }
}
