package co.edu.usa.reto3.audience.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.usa.reto3.audience.model.Mensaje;
import co.edu.usa.reto3.audience.repository.MensajeRepositorio;

@Service
public class MensajeServicio {
    @Autowired
    private MensajeRepositorio mensajeRepositorio;

    public List<Mensaje>getAll(){
        return mensajeRepositorio.getAll();
    }

    public Optional<Mensaje>getMensaje(int id){
        return mensajeRepositorio.getMensaje(id);
    }

    public Mensaje save(Mensaje mensaje){
        //Verificar si el id es nulo
        if(mensaje.getNumId()==null){
            return mensajeRepositorio.save(mensaje);
        }else{//Verifico si existe o no en la base de datos
            Optional<Mensaje> consulta=mensajeRepositorio.getMensaje(mensaje.getNumId());
            if (consulta.isEmpty()){
                return mensajeRepositorio.save(mensaje);
            }else{
                return mensaje;
            }
        }   
    }
}
