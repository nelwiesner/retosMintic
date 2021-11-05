package co.edu.usa.reto3.audience.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import co.edu.usa.reto3.audience.model.Calificacion;
import co.edu.usa.reto3.audience.service.CalificacionServicio;

@RestController
@RequestMapping("/api/Score")
public class CalificacionControlador {
    @Autowired
    private CalificacionServicio calificacionServicio;

    @GetMapping("/all")
    public List<Calificacion>getCalificacion(){
        return calificacionServicio.getAll();
    }

    @GetMapping("/{id")
    public Optional<Calificacion>getCalificacion(@PathVariable("id") int id){
        return calificacionServicio.getCalificacion(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    
    public Calificacion save(@RequestBody Calificacion calificacion){
        return calificacionServicio.save(calificacion);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Calificacion update(@RequestBody Calificacion calificacion){
        return calificacionServicio.update(calificacion);
    }

    @DeleteMapping("/{numId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCalificacion(@PathVariable("numId") int numId){
        return calificacionServicio.deleteCalificacion(numId);

    }
}
