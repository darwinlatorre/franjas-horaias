package co.edu.unicauca.asae.taller_2.oficina.domain;

import co.edu.unicauca.asae.taller_2.docente.domain.Docente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Oficina {
    private Long id;
    private String nombre;
    private String ubicacion;
    private Docente docente;
}
