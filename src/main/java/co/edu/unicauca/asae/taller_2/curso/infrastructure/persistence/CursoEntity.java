package co.edu.unicauca.asae.taller_2.curso.infrastructure.persistence;

import java.time.LocalDateTime;
import java.util.List;

import co.edu.unicauca.asae.taller_2.asignatura.infrastructure.persistence.AsignaturaEntity;
import co.edu.unicauca.asae.taller_2.docente.infrastructure.persistence.DocenteEntity;
import co.edu.unicauca.asae.taller_2.franja_horaria.infrastructure.persistence.FranjaHorariaEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "curso")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false, unique = true)
    private String nombre;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "asignatura_id", nullable = false)
    private AsignaturaEntity asignatura;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "curso_docente", joinColumns = @JoinColumn(name = "curso_id"), inverseJoinColumns = @JoinColumn(name = "docente_id"))
    private List<DocenteEntity> docentes;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "curso", fetch = FetchType.LAZY)
    private List<FranjaHorariaEntity> franjasHorarias;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}