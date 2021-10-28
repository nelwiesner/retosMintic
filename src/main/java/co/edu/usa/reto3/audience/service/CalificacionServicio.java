package co.edu.usa.reto3.audience.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.usa.reto3.audience.model.Calificacion;
import co.edu.usa.reto3.audience.repository.CalificacionRepositorio;

@Service
public class CalificacionServicio {
    @Autowired
    private CalificacionRepositorio calificacionRepositorio;

    public List<Calificacion>getAll(){
        return calificacionRepositorio.getAll();
    }

    public Optional<Calificacion>getCalificacion(int id){
        return calificacionRepositorio.getCalificacion(id);
    }

    public Calificacion save(Calificacion calificacion){
        //Verificar si el id es nulo
        if(calificacion.getNumId()==null){
            return calificacionRepositorio.save(calificacion);
        }else{//Verifico si existe o no en la base de datos
            Optional<Calificacion> consulta=calificacionRepositorio.getCalificacion(calificacion.getNumId());
            if (consulta.isEmpty()){
                return calificacionRepositorio.save(calificacion);
            }else{
                return calificacion;
            }
        }   
    }
}
