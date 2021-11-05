package co.edu.usa.reto3.audience.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.usa.reto3.audience.model.Cliente;
import co.edu.usa.reto3.audience.repository.ClienteRepositorio;

@Service
public class ClienteServicio {
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public List<Cliente>getAll(){
        return clienteRepositorio.getAll();
    }

    public Optional<Cliente>getCliente(int id){
        return clienteRepositorio.getCliente(id);
    }

    public Cliente save(Cliente cliente){
        //Verificar si el id es nulo
        if(cliente.getIdClient()==null){
            return clienteRepositorio.save(cliente);
        }else{//Verifico si existe o no en la base de datos
            Optional<Cliente> consulta=clienteRepositorio.getCliente(cliente.getIdClient());
            if (consulta.isEmpty()){
                return clienteRepositorio.save(cliente);
            }else{
                return cliente;
            }
        }   
    }

    public Cliente update(Cliente cliente){
        if (cliente.getIdClient()!=null){
            Optional<Cliente> consulta=clienteRepositorio.getCliente(cliente.getIdClient());
            if (!consulta.isEmpty()) {
                if(cliente.getEmail()!=null){
                    consulta.get().setEmail(cliente.getEmail());
                }
				if(cliente.getPassword()!=null){
                    consulta.get().setPassword(cliente.getPassword());
                }
				if(cliente.getName()!=null){
                    consulta.get().setName(cliente.getName());
                }
                if(cliente.getAge()!=null){
                    consulta.get().setAge(cliente.getAge());
                }                
                return clienteRepositorio.save(consulta.get());
            }
        }
        return cliente;
    }
	
    public boolean deleteCliente(int idClient){
        Optional<Cliente> consulta=clienteRepositorio.getCliente(idClient);
        if (!consulta.isEmpty()) {
            clienteRepositorio.delete(consulta.get());
            return true;
            
        }
        return false;
    }
}
