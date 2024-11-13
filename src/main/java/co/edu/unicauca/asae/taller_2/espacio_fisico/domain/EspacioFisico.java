package co.edu.unicauca.asae.taller_2.espacio_fisico.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EspacioFisico {
    private Long id;
    private String nombre;
    private int capacidad;
}
