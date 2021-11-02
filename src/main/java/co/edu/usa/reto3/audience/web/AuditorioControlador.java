package co.edu.usa.reto3.audience.web;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
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
    public Auditorio save(@RequestBody Auditorio dpto){
        return auditorioServicio.save(dpto);
    }

    public AuditorioServicio getAuditorioServicio() {
        return auditorioServicio;
    }

    public void setAuditorioServicio(AuditorioServicio auditorioServicio) {
        this.auditorioServicio = auditorioServicio;
    }
}
