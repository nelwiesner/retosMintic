package co.edu.usa.reto3.audience.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import co.edu.usa.reto3.audience.model.Auditorio;
import co.edu.usa.reto3.audience.service.AuditorioServicio;

@RestController
@RequestMapping("/api/Audience")
@CrossOrigin(origins="*",methods = {RequestMethod.GET,RequestMethod.POST,
    RequestMethod.DELETE,RequestMethod.PUT})
public class AuditorioControlador {
    @Autowired
    private AuditorioServicio auditorioServicio;

    @GetMapping("/all")
    public List<Auditorio>getAuditorios(){
        return auditorioServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Auditorio>getAuditorio(@PathVariable("id") int id){
        return auditorioServicio.getAuditorio(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Auditorio save(@RequestBody Auditorio auditorio){
        return auditorioServicio.save(auditorio);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Auditorio update(@RequestBody Auditorio auditorio){
        return auditorioServicio.update(auditorio);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteAuditorio(@PathVariable("id") int id){
        return auditorioServicio.deleteAuditorio(id);

    }
}
