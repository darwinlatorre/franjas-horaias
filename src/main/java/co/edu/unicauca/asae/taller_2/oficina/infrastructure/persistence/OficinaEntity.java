package co.edu.unicauca.asae.taller_2.oficina.infrastructure.persistence;

import java.time.LocalDateTime;

import co.edu.unicauca.asae.taller_2.docente.infrastructure.persistence.DocenteEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "oficina")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OficinaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false, unique = true)
    private String nombre;

    @Column(length = 20, nullable = false)
    private String ubicacion;

    @OneToOne(mappedBy = "oficina")
    private DocenteEntity docente;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

}
