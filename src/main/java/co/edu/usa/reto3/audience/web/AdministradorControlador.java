package co.edu.usa.reto3.audience.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Administrador update(@RequestBody Administrador administrador){
        return administradorServicio.update(administrador);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteAdministrador(@PathVariable("id") int id){
        return administradorServicio.deleteAdministrador(id);

    }
}
