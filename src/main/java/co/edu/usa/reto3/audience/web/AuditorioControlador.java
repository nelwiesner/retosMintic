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
    private AuditorioServicio departamentoServicio;

    @GetMapping("/all")
    public List<Auditorio>getDepartamentos(){
        return departamentoServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Auditorio>getDepartamento(@PathVariable("id") int id){
        return departamentoServicio.getDepartamento(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Auditorio save(@RequestBody Auditorio dpto){
        return departamentoServicio.save(dpto);
    }

    public AuditorioServicio getDepartamentoServicio() {
        return departamentoServicio;
    }

    public void setDepartamentoServicio(AuditorioServicio departamentoServicio) {
        this.departamentoServicio = departamentoServicio;
    }
}
