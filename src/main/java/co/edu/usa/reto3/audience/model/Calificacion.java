package co.edu.usa.reto3.audience.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="calificacion")
public class Calificacion implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numId;
    private Integer calificacion;
    private String mensaje;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "calificacion")
    @JsonIgnoreProperties("calificacion")
    private List<Reserva> reservas;

    public Integer getNumId() {
        return numId;
    }
    public void setNumId(Integer numId) {
        this.numId = numId;
    }
    public Integer getCalificacion() {
        return calificacion;
    }
    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
