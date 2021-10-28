package co.edu.usa.reto3.audience.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import co.edu.usa.reto3.audience.model.Administrador;
import co.edu.usa.reto3.audience.service.AdministradorServicio;

@RestController
@RequestMapping("/api/Admin")
public class AdministradorControlador {
    @Autowired
    private AdministradorServicio administradorServicio;

    @GetMapping("/all")
    public List<Administrador>getAdministrador(){
        return administradorServicio.getAll();
    }

    @GetMapping("/{id")
    public Optional<Administrador>getAdministrador(@PathVariable("id") int id){
        return administradorServicio.getAdministrador(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    
    public Administrador save(@RequestBody Administrador administrador){
        return administradorServicio.save(administrador);
    }
}
