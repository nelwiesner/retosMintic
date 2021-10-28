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
import co.edu.usa.reto3.audience.model.Reserva;
import co.edu.usa.reto3.audience.service.ReservaServicio;

@RestController
@RequestMapping("/api/Reservation")
public class ReservaControlador {
    @Autowired
    private ReservaServicio reservaServicio;

    @GetMapping("/all")
    public List<Reserva>getReserva(){
        return reservaServicio.getAll();
    }

    @GetMapping("/{id")
    public Optional<Reserva>getReserva(@PathVariable("id") int id){
        return reservaServicio.getReserva(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    
    public Reserva save(@RequestBody Reserva reserva){
        return reservaServicio.save(reserva);
    }
}
