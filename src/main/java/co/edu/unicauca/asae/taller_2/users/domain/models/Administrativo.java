package co.edu.unicauca.asae.taller_2.users.domain.models;

public class Administrativo extends Persona {
    private String rol;

    public Administrativo(Long id, String nombre, String apellido, String correo, String rol) {
        super(id, nombre, apellido, correo);
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
