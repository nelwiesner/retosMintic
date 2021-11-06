package co.edu.usa.reto3.audience.model.reportes;

import co.edu.usa.reto3.audience.model.Cliente;

public class ConReservas {

    private Long total;
    private Cliente client;
    public ConReservas(Long total, Cliente client) {
        this.total = total;
        this.client = client;
    }
    
    public Long getTotal() {
        return total;
    }
    public void setTotal(Long total) {
        this.total = total;
    }
    public Cliente getClient() {
        return client;
    }
    public void setClient(Cliente client) {
        this.client = client;
    }
            
}
