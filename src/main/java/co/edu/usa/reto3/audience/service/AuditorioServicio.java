package co.edu.usa.reto3.audience.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.usa.reto3.audience.repository.AuditorioRepositorio;
import co.edu.usa.reto3.audience.model.Auditorio;

@Service

public class AuditorioServicio {
    @Autowired
    AuditorioRepositorio departamentoRepositorio;

    public List<Auditorio> getAll(){
        return departamentoRepositorio.getAll();
    }

    public Optional<Auditorio>getDepartamento(int id){
        return departamentoRepositorio.getDepartamento(id);
    }

    public Auditorio save(Auditorio dpto){
        //Verificar si el id es nulo
        if (dpto.getNumId()==null) {
            return departamentoRepositorio.save(dpto);
        }else{//Verifico si existe el id o no en la base de datos
            Optional<Auditorio> consulta=departamentoRepositorio.getDepartamento(dpto.getNumId());
        if (consulta.isEmpty()) {
            return departamentoRepositorio.save(dpto);
        }else{
            return dpto;
        }
        }
    }  
}
