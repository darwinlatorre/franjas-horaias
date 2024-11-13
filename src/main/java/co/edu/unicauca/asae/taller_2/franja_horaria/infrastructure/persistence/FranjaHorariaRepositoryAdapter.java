package co.edu.unicauca.asae.taller_2.franja_horaria.infrastructure.persistence;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.taller_2.franja_horaria.application.ports.FranjaHorariaRepositoryPort;
import co.edu.unicauca.asae.taller_2.franja_horaria.domain.FranjaHoraria;
import jakarta.transaction.Transactional;

@Repository
public class FranjaHorariaRepositoryAdapter implements FranjaHorariaRepositoryPort {

    @Autowired
    private FranjaHorariaRepository franjaHorariaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public FranjaHoraria crear(FranjaHoraria franjaHoraria) {
        FranjaHorariaEntity franjaHorariaEntity = modelMapper.map(franjaHoraria, FranjaHorariaEntity.class);
        franjaHorariaEntity = franjaHorariaRepository.save(franjaHorariaEntity);
        return modelMapper.map(franjaHorariaEntity, FranjaHoraria.class);
    }

    public List<FranjaHoraria> buscarPorDocente(Long docenteId) {
        List<FranjaHorariaEntity> franjasEntity = franjaHorariaRepository.findByCurso_Docentes_Id(docenteId);
        return franjasEntity.stream().map(franjaEntity -> modelMapper.map(franjaEntity, FranjaHoraria.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<FranjaHoraria> listar() {
        List<FranjaHorariaEntity> franjasEntity = franjaHorariaRepository.findAll();
        return franjasEntity.stream().map(franjaEntity -> modelMapper.map(franjaEntity, FranjaHoraria.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<FranjaHoraria> listarPorDocente(Long id) {
        List<FranjaHorariaEntity> franjasEntity = franjaHorariaRepository.findByCurso_Docentes_Id(id);
        return franjasEntity.stream().map(franjaEntity -> modelMapper.map(franjaEntity, FranjaHoraria.class))
                .collect(Collectors.toList());
    }

    public boolean isEspacioFisicoOcupado(String dia, LocalTime horaInicio, LocalTime horaFin, Long espacioFisicoId) {
        return franjaHorariaRepository.isEspacioFisicoOcupado(dia, horaInicio, horaFin, espacioFisicoId);
    }

    public boolean isDocenteOcupado(String dia, LocalTime horaInicio, LocalTime horaFin, Long docenteId) {
        return franjaHorariaRepository.isDocenteOcupado(dia, horaInicio, horaFin, docenteId);
    }

}
