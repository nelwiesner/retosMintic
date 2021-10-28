package co.edu.usa.reto3.audience.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="auditorio")
public class Auditorio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numId;
    private String propietario;
    private String nombre;
    private Integer capacidad;
    private String decripcion;

    @ManyToOne
    @JoinColumn(name="categoria_id")
    @JsonIgnoreProperties("auditorios")
    private Categoria categoria;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "auditorio")
    @JsonIgnoreProperties("auditorio")
    private List<Mensaje> mensajes;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "auditorio")
    @JsonIgnoreProperties("auditorio")
    private List<Reserva> reservas;

    @ManyToOne
    @JoinColumn(name="administrador_id")
    @JsonIgnoreProperties("auditorios")
    private Administrador administrador;
   
    public Integer getNumId() {
        return numId;
    }

    public void setNumId(Integer numId) {
        this.numId = numId;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getDecripcion() {
        return decripcion;
    }

    public void setDecripcion(String decripcion) {
        this.decripcion = decripcion;
    }
}
