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
import co.edu.usa.reto3.audience.model.Mensaje;
import co.edu.usa.reto3.audience.service.MensajeServicio;

@RestController
@RequestMapping("/api/Message")
public class MensajeControlador {
    @Autowired
    private MensajeServicio mensajeServicio;

    @GetMapping("/all")
    public List<Mensaje>getMensaje(){
        return mensajeServicio.getAll();
    }

    @GetMapping("/{id")
    public Optional<Mensaje>getMensaje(@PathVariable("id") int id){
        return mensajeServicio.getMensaje(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    
    public Mensaje save(@RequestBody Mensaje mensaje){
        return mensajeServicio.save(mensaje);
    }
}
