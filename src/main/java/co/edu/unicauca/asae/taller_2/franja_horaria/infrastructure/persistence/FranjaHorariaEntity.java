package co.edu.unicauca.asae.taller_2.franja_horaria.infrastructure.persistence;

import java.time.LocalDateTime;
import java.time.LocalTime;

import co.edu.unicauca.asae.taller_2.curso.infrastructure.persistence.CursoEntity;
import co.edu.unicauca.asae.taller_2.espacio_fisico.infrastructure.persistence.EspacioFisicoEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "franja_horaria")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FranjaHorariaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String dia;

    @Column(nullable = false)
    private LocalTime horaInicio;

    @Column(nullable = false)
    private LocalTime horaFin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "curso_id", nullable = false)
    private CursoEntity curso;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "espacio_fisico_id", nullable = false)
    private EspacioFisicoEntity espacioFisico;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

}