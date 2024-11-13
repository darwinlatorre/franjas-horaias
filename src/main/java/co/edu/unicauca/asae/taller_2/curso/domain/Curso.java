package co.edu.unicauca.asae.taller_2.curso.domain;

import java.util.List;

import co.edu.unicauca.asae.taller_2.asignatura.domain.Asignatura;
import co.edu.unicauca.asae.taller_2.docente.domain.Docente;
import co.edu.unicauca.asae.taller_2.franja_horaria.domain.FranjaHoraria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    private Long id;
    private String nombre;
    private Asignatura asignatura;
    private List<Docente> docentes;
    private List<FranjaHoraria> franjaHoraria;
}
