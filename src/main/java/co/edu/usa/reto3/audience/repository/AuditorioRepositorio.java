package co.edu.usa.reto3.audience.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.reto3.audience.repository.crud.AuditorioCrudRepositorio;
import co.edu.usa.reto3.audience.model.Auditorio;

@Repository
public class AuditorioRepositorio {
    @Autowired
    AuditorioCrudRepositorio auditorioCrudRepositorio;

    public List<Auditorio>getAll(){
        return (List<Auditorio>)auditorioCrudRepositorio.findAll();
    }
    public Optional<Auditorio>getAuditorio(int id){
        return auditorioCrudRepositorio.findById(id);
    }
    public Auditorio save(Auditorio auditorio){
        return auditorioCrudRepositorio.save(auditorio);
    }
    public void delete (Auditorio auditorio){
        auditorioCrudRepositorio.delete(auditorio);
    }
}
