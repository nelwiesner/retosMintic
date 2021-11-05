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

    public Auditorio update(Auditorio auditorio){
        if (auditorio.getId()!=null){
            Optional<Auditorio> consulta=auditorioRepositorio.getAuditorio(auditorio.getId());
            if (!consulta.isEmpty()) {
                if(auditorio.getOwner()!=null){
                    consulta.get().setOwner(auditorio.getOwner());
                }
                if(auditorio.getCapacity()!=null){
                    consulta.get().setCapacity(auditorio.getCapacity());
                }
                if(auditorio.getName()!=null){
                    consulta.get().setName(auditorio.getName());
                }
                if(auditorio.getDescription()!=null){
                    consulta.get().setDescription(auditorio.getDescription());
                }

                return auditorioRepositorio.save(consulta.get());
            }
        }
        return auditorio;
    }
    
    public boolean deleteAuditorio(int id){
        Optional<Auditorio> consulta=auditorioRepositorio.getAuditorio(id);
        if (!consulta.isEmpty()) {
            auditorioRepositorio.delete(consulta.get());
            return true;
            
        }
        return false;
    }
}
