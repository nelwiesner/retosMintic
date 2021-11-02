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
    AuditorioRepositorio auditorioRepositorio;

    public List<Auditorio> getAll(){
        return auditorioRepositorio.getAll();
    }

    public Optional<Auditorio>getAuditorio(int id){
        return auditorioRepositorio.getAuditorio(id);
    }

    public Auditorio save(Auditorio dpto){
        //Verificar si el id es nulo
        if (dpto.getId()==null) {
            return auditorioRepositorio.save(dpto);
        }else{//Verifico si existe el id o no en la base de datos
            Optional<Auditorio> consulta=auditorioRepositorio.getAuditorio(dpto.getId());
        if (consulta.isEmpty()) {
            return auditorioRepositorio.save(dpto);
        }else{
            return dpto;
        }
        }
    }  
}
