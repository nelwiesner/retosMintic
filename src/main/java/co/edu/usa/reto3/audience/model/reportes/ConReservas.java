package co.edu.usa.reto3.audience.model.reportes;

import co.edu.usa.reto3.audience.model.Cliente;

public class ConReservas {

    private Long total;
    private Cliente cliente;
    public ConReservas(Long total, Cliente cliente) {
        this.total = total;
        this.cliente = cliente;
    }
    
    public Long getTotal() {
        return total;
    }
    public void setTotal(Long total) {
        this.total = total;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
            
}
