package co.edu.unicauca.asae.taller_2.docente.infrastructure.persistence;

import java.time.LocalDateTime;
import java.util.List;

import co.edu.unicauca.asae.taller_2.curso.infrastructure.persistence.CursoEntity;
import co.edu.unicauca.asae.taller_2.oficina.infrastructure.persistence.OficinaEntity;
import co.edu.unicauca.asae.taller_2.users.infrastructure.persistence.entity.PersonaEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "docente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocenteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "persona_id", nullable = false)
    private PersonaEntity persona;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "oficina_id", nullable = false, unique = true)
    private OficinaEntity oficina;

    @ManyToMany(mappedBy = "docentes", fetch = FetchType.LAZY)
    private List<CursoEntity> cursos;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

}