package co.edu.usa.reto3.audience.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="administrador")
public class Administrador implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombreAdministrador;
    private String emailAdministrador;
    private String paswordAdministrador;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
