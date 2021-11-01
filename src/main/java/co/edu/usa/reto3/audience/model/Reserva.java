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
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status;

    @ManyToOne
    @JoinColumn(name="auditorio_id")
    @JsonIgnoreProperties("reserva")
    private Auditorio audience;

    @ManyToOne
    @JoinColumn(name="cliente_id")
    @JsonIgnoreProperties("reserva")
    private Cliente client;

    @ManyToOne
    @JoinColumn(name="calificacion_id")
    @JsonIgnoreProperties("reserva")
    private Calificacion score;

    public Integer getidReservation() {
        return idReservation;
    }
    public void setidReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }
    public Date getstartDate() {
        return startDate;
    }
    public void setstartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getdevolutionDate() {
        return devolutionDate;
    }
    public void setdevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
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
