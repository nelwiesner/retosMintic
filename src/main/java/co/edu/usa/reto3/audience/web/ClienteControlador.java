package co.edu.usa.reto3.audience.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update(@RequestBody Cliente cliente){
        return clienteServicio.update(cliente);
    }

    @DeleteMapping("/{idClient}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCliente(@PathVariable("idClient") int idClient){
        return clienteServicio.deleteCliente(idClient);

    }
}
