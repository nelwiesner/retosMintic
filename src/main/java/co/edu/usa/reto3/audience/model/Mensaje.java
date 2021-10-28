package co.edu.usa.reto3.audience.model;

import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="mensaje")
public class Mensaje implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numId;
    private String mensaje;
    private String emailMensaje;

    @ManyToOne
    @JoinColumn(name="auditorio_id")
    @JsonIgnoreProperties("mensaje")
    private Auditorio auditorio;

    @ManyToOne
    @JoinColumn(name="cliente_id")
    @JsonIgnoreProperties("mensaje")
    private Cliente cliente;

    public Integer getNumId() {
        return numId;
    }
    public void setNumId(Integer numId) {
        this.numId = numId;
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public String getEmailMensaje() {
        return emailMensaje;
    }
    public void setEmailMensaje(String emailMensaje) {
        this.emailMensaje = emailMensaje;
    }

}
