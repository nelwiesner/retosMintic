package co.edu.usa.reto3.audience.model;

import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="mensaje")
public class Mensaje implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;

    @ManyToOne
    @JoinColumn(name="auditorio_id")
    @JsonIgnoreProperties("messages")
    private Auditorio audience;

    @ManyToOne
    @JoinColumn(name="cliente_idClient")
    @JsonIgnoreProperties("messages")
    private Cliente client;

    public Integer getIdMessage() {
        return idMessage;
    }
    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }
    public String getMessageText() {
        return messageText;
    }
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
    public Auditorio getAudience() {
        return audience;
    }
    public void setAudience(Auditorio audience) {
        this.audience = audience;
    }
    public Cliente getClient() {
        return client;
    }
    public void setClient(Cliente client) {
        this.client = client;
    }

}
