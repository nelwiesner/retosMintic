package co.edu.usa.reto3.audience.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import co.edu.usa.reto3.audience.model.Cliente;
import co.edu.usa.reto3.audience.service.ClienteServicio;

@RestController
@RequestMapping("/api/Client")

public class ClienteControlador {
    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping("/all")
    public List<Cliente>getCliente(){
        return clienteServicio.getAll();
    }

    @GetMapping("/{id")
    public Optional<Cliente>getCliente(@PathVariable("id") int id){
        return clienteServicio.getCliente(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    
    public Cliente save(@RequestBody Cliente cliente){
        return clienteServicio.save(cliente);
    }
}
