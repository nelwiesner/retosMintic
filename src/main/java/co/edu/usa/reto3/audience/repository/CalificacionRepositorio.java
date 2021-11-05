package co.edu.usa.reto3.audience.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.reto3.audience.repository.crud.CalificacionCrudRepositorio;
import co.edu.usa.reto3.audience.model.Calificacion;

@Repository

public class CalificacionRepositorio {
    @Autowired
    CalificacionCrudRepositorio calificacionCrudRepositorio;
    public List<Calificacion>getAll(){
        return (List<Calificacion>)calificacionCrudRepositorio.findAll();
    }
    public Optional<Calificacion>getCalificacion(int id){
        return calificacionCrudRepositorio.findById(id);
    }
    
    public Calificacion save(Calificacion calificacion){
        return calificacionCrudRepositorio.save(calificacion);
    }

    public void delete(Calificacion calificacion){
        calificacionCrudRepositorio.delete(calificacion);
    }
}
