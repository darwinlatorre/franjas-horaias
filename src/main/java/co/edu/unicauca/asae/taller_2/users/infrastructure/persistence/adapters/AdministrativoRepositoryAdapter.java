package co.edu.unicauca.asae.taller_2.users.infrastructure.persistence.adapters;

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

    public Administrativo crear(Administrativo administrativo) {
        AdministrativoEntity administrativoEntity = modelMapper.map(administrativo, AdministrativoEntity.class);
        administrativoEntity = administrativoRepository.save(administrativoEntity);
        return modelMapper.map(administrativoEntity, Administrativo.class);
    }

    public Administrativo encontrarPorId(Long ID) {
        AdministrativoEntity administrativoEntity = administrativoRepository.findById(ID).orElse(null);
        if (administrativoEntity != null) {
            return modelMapper.map(administrativoEntity, Administrativo.class);
        }
        return null;
    }
}
