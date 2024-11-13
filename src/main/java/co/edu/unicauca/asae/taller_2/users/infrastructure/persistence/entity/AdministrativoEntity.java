package co.edu.unicauca.asae.taller_2.users.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(name = "administrativo_id")
@Getter
@Setter
@NoArgsConstructor
@Table(name = "administrativo")
public class AdministrativoEntity extends PersonaEntity {

    @Column(length = 255, nullable = false)
    private String rol;

}