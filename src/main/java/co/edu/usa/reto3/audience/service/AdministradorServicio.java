package co.edu.usa.reto3.audience.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.usa.reto3.audience.model.Administrador;
import co.edu.usa.reto3.audience.repository.AdministradorRepositorio;

@Service
public class AdministradorServicio {
    @Autowired
    private AdministradorRepositorio administradorRepositorio;

    public List<Administrador>getAll(){
        return administradorRepositorio.getAll();
    }

    public Optional<Administrador>getAdministrador(int id){
        return administradorRepositorio.getAdministrador(id);
    }

    public Administrador save(Administrador administrador){
        //Verificar si el id es nulo
        if(administrador.getNumId()==null){
            return administradorRepositorio.save(administrador);
        }else{//Verifico si existe o no en la base de datos
            Optional<Administrador> consulta=administradorRepositorio.getAdministrador(administrador.getNumId());
            if (consulta.isEmpty()){
                return administradorRepositorio.save(administrador);
            }else{
                return administrador;
            }
        }   
    }
}
