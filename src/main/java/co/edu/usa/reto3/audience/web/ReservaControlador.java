package co.edu.usa.reto3.audience.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva update(@RequestBody Reserva reserva){
        return reservaServicio.update(reserva);
    }

    @DeleteMapping("/{idReservation}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteReserva(@PathVariable("idReservation") int idReservation){
        return reservaServicio.deleteReserva(idReservation);

    }
}
