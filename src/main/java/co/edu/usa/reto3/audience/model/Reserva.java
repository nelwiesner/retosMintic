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
    @JsonIgnoreProperties("reservations")
    private Auditorio audience;

    @ManyToOne
    @JoinColumn(name="cliente_idClient")
    @JsonIgnoreProperties("reservations")
    private Cliente client;

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
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
