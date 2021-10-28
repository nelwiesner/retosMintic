package co.edu.usa.reto3.audience.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numId;
    private String nombreCliente;
    private String emailCliente;
    private Integer edadCliente;
    private String paswordCliente;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cliente")
    @JsonIgnoreProperties("cliente")
    private List<Reserva> reservas;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cliente")
    @JsonIgnoreProperties("cliente")
    private List<Mensaje> mensajes;

    public Integer getNumId() {
        return numId;
    }
    public void setNumId(Integer numId) {
        this.numId = numId;
    }
    public String getNombreCliente() {
        return nombreCliente;
    }
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    public String getEmailCliente() {
        return emailCliente;
    }
    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }
    public Integer getEdadCliente() {
        return edadCliente;
    }
    public void setEdadCliente(Integer edadCliente) {
        this.edadCliente = edadCliente;
    }
    public String getPaswordCliente() {
        return paswordCliente;
    }
    public void setPaswordCliente(String paswordCliente) {
        this.paswordCliente = paswordCliente;
    } 
}
