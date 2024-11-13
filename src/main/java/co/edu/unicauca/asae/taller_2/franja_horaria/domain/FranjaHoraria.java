package co.edu.unicauca.asae.taller_2.franja_horaria.domain;

import java.time.LocalTime;

import co.edu.unicauca.asae.taller_2.curso.domain.Curso;
import co.edu.unicauca.asae.taller_2.espacio_fisico.domain.EspacioFisico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FranjaHoraria {
    private Long id;
    private String dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Curso curso;
    private EspacioFisico espacioFisico;

    private static final LocalTime HORA_MINIMA = LocalTime.of(6, 0);
    private static final LocalTime HORA_MAXIMA = LocalTime.of(22, 0);

    public boolean esHoraInicioAntesDeHoraFin() {
        return horaInicio.isBefore(horaFin);
    }

    public boolean esDuracionPositiva() {
        return !horaInicio.equals(horaFin);
    }

    public boolean estaDentroDelRangoPermitido() {
        return !horaInicio.isBefore(HORA_MINIMA) && !horaFin.isAfter(HORA_MAXIMA);
    }
}
