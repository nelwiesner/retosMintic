package co.edu.usa.reto3.audience.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import co.edu.usa.reto3.audience.model.Reserva;
import co.edu.usa.reto3.audience.service.ReservaServicio;
import co.edu.usa.reto3.audience.model.reportes.ConReservas;
import co.edu.usa.reto3.audience.model.reportes.ConEstadosReservas;

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

    @GetMapping("/reporteEstados")
    public ConEstadosReservas getReprteEstados(){
        return reservaServicio.getReporteEstados();
    }

    @GetMapping("/reporteClientes")
    public List<ConReservas> getTopClientes(){
        return reservaServicio.getTopClientes();
    }

    @GetMapping("/reporteFechas/{fechaIni}/{fechaFin}")
    public List<Reserva> getReservaFechas(@PathVariable("fechaIni") String fecha1, @PathVariable("fechaFin") String fecha2){
        return reservaServicio.getReservaFechas(fecha1, fecha2);

    }
}
