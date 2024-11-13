package co.edu.unicauca.asae.taller_2.espacio_fisico.infrastructure.persistence;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "espacio_fisico")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EspacioFisicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(length = 255, nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false)
    private int capacidad;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

}
