package co.edu.usa.reto3.audience.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.reto3.audience.repository.crud.MensajeCrudRepositorio;
import co.edu.usa.reto3.audience.model.Mensaje;

@Repository
public class MensajeRepositorio {
    @Autowired
    MensajeCrudRepositorio mensajeCrudRepositorio;
    public List<Mensaje>getAll(){
        return (List<Mensaje>)mensajeCrudRepositorio.findAll();
    }
    public Optional<Mensaje>getMensaje(int id){
        return mensajeCrudRepositorio.findById(id);
    }
    public Mensaje save(Mensaje mensaje){
        return mensajeCrudRepositorio.save(mensaje);
    }

    public void delete(Mensaje mensaje){
        mensajeCrudRepositorio.delete(mensaje);
    }
}
