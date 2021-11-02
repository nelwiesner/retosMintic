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
    private Integer id;
    private String owner;
    private String name;
    private Integer capacity;
    private String description;

    @ManyToOne
    @JoinColumn(name="categoria_id")
    @JsonIgnoreProperties("audiences")
    private Categoria category;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "audience")
    @JsonIgnoreProperties("audience")
    private List<Mensaje> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "audience")
    @JsonIgnoreProperties("audience")
    private List<Reserva> reservations;
   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getDecripcion() {
        return description;
    }

    public void setDecripcion(String description) {
        this.description = description;
    }
}
