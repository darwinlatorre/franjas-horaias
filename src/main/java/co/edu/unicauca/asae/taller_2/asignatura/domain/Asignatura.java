package co.edu.unicauca.asae.taller_2.asignatura.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Asignatura {
    private Long id;
    private String nombre;
    private String codigo;
}
