package co.edu.usa.reto3.audience.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="reserva")
public class Reserva implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numId;
    private Date fechaCreacionDate;
    private Date fechaEntregaDate;
    private String statusReserva;
    private String emailReserva;

    @ManyToOne
    @JoinColumn(name="auditorio_id")
    @JsonIgnoreProperties("reserva")
    private Auditorio auditorio;

    @ManyToOne
    @JoinColumn(name="cliente_id")
    @JsonIgnoreProperties("reserva")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="calificacion_id")
    @JsonIgnoreProperties("reserva")
    private Calificacion calificacion;

    public Integer getNumId() {
        return numId;
    }
    public void setNumId(Integer numId) {
        this.numId = numId;
    }
    public Date getFechaCreacionDate() {
        return fechaCreacionDate;
    }
    public void setFechaCreacionDate(Date fechaCreacionDate) {
        this.fechaCreacionDate = fechaCreacionDate;
    }
    public Date getFechaEntregaDate() {
        return fechaEntregaDate;
    }
    public void setFechaEntregaDate(Date fechaEntregaDate) {
        this.fechaEntregaDate = fechaEntregaDate;
    }
    public String getStatusReserva() {
        return statusReserva;
    }
    public void setStatusReserva(String statusReserva) {
        this.statusReserva = statusReserva;
    }
    public String getEmailReserva() {
        return emailReserva;
    }
    public void setEmailReserva(String emailReserva) {
        this.emailReserva = emailReserva;
    }

   
}
