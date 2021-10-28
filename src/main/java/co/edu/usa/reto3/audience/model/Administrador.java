package co.edu.usa.reto3.audience.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="administrador")
public class Administrador implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numId;
    private String nombreAdministrador;
    private String emailAdministrador;
    private String paswordAdministrador;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "administrador")
    @JsonIgnoreProperties("administrador")
    private List<Auditorio> auditorios;
    
    public Integer getNumId() {
        return numId;
    }
    public void setNumId(Integer numId) {
        this.numId = numId;
    }
    public String getNombreAdministrador() {
        return nombreAdministrador;
    }
    public void setNombreAdministrador(String nombreAdministrador) {
        this.nombreAdministrador = nombreAdministrador;
    }
    public String getEmailAdministrador() {
        return emailAdministrador;
    }
    public void setEmailAdministrador(String emailAdministrador) {
        this.emailAdministrador = emailAdministrador;
    }
    public String getPaswordAdministrador() {
        return paswordAdministrador;
    }
    public void setPaswordAdministrador(String paswordAdministrador) {
        this.paswordAdministrador = paswordAdministrador;
    }

    
}
