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
        if(administrador.getId()==null){
            return administradorRepositorio.save(administrador);
        }else{//Verifico si existe o no en la base de datos
            Optional<Administrador> consulta=administradorRepositorio.getAdministrador(administrador.getId());
            if (consulta.isEmpty()){
                return administradorRepositorio.save(administrador);
            }else{
                return administrador;
            }
        }   
    }
    public Administrador update(Administrador administrador){
        if (administrador.getId()!=null){
            Optional<Administrador> consulta=administradorRepositorio.getAdministrador(administrador.getId());
            if (!consulta.isEmpty()) {
                if(administrador.getNombreAdministrador()!=null){
                    consulta.get().setNombreAdministrador(administrador.getNombreAdministrador());
                }
                if(administrador.getEmailAdministrador()!=null){
                    consulta.get().setEmailAdministrador(administrador.getEmailAdministrador());
                }
                if(administrador.getPaswordAdministrador()!=null){
                    consulta.get().setPaswordAdministrador(administrador.getPaswordAdministrador());
                }
                
                return administradorRepositorio.save(consulta.get());
            }
        }
        return administrador;
    }
	
    public boolean deleteAdministrador(int numId){
        Optional<Administrador> consulta=administradorRepositorio.getAdministrador(numId);
        if (!consulta.isEmpty()) {
            administradorRepositorio.delete(consulta.get());
            return true;
            
        }
        return false;
    }
}
