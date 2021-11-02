package co.edu.usa.reto3.audience.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="calificacion")
public class Calificacion implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numId;
    private Integer calificacion;
    private String mensaje;

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
