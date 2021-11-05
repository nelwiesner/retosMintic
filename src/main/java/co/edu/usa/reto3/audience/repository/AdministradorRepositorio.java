package co.edu.usa.reto3.audience.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.reto3.audience.repository.crud.AdministradorCrudRepositorio;
import co.edu.usa.reto3.audience.model.Administrador;

@Repository
public class AdministradorRepositorio {
    @Autowired
    AdministradorCrudRepositorio administradorCrudRepositorio;
    public List<Administrador>getAll(){
        return (List<Administrador>)administradorCrudRepositorio.findAll();
    }
    public Optional<Administrador>getAdministrador(int id){
        return administradorCrudRepositorio.findById(id);
    }
    public Administrador save(Administrador administrador){
        return administradorCrudRepositorio.save(administrador);
    }
    public void delete(Administrador administrador){
        administradorCrudRepositorio.delete(administrador);
    }
}
