package co.edu.usa.reto3.audience.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.reto3.audience.repository.crud.ClienteCrudRepositorio;
import co.edu.usa.reto3.audience.model.Cliente;

@Repository
public class ClienteRepositorio {
    @Autowired
    ClienteCrudRepositorio clienteCrudRepositorio;
    public List<Cliente>getAll(){
        return (List<Cliente>)clienteCrudRepositorio.findAll();
    }
    public Optional<Cliente>getCliente(int id){
        return clienteCrudRepositorio.findById(id);
    }
    
    public Cliente save(Cliente cliente){
        return clienteCrudRepositorio.save(cliente);
    }

    public void delete(Cliente cliente){
        clienteCrudRepositorio.delete(cliente);
    }
}
