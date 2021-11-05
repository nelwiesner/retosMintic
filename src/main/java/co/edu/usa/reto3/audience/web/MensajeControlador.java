package co.edu.usa.reto3.audience.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje update(@RequestBody Mensaje mensaje){
        return mensajeServicio.update(mensaje);
    }

    @DeleteMapping("/{idMessage}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteMensaje(@PathVariable("idMessage") int idMessage){
        return mensajeServicio.deleteMensaje(idMessage);

    }
}
