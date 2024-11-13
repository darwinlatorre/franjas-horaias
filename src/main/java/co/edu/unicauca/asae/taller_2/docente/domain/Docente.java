package co.edu.unicauca.asae.taller_2.docente.domain;

import java.util.List;

import co.edu.unicauca.asae.taller_2.curso.domain.Curso;
import co.edu.unicauca.asae.taller_2.oficina.domain.Oficina;
import co.edu.unicauca.asae.taller_2.users.domain.models.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Docente {
    private Long id;
    private Persona persona;
    private Oficina oficina;
    private List<Curso> cursos;
}