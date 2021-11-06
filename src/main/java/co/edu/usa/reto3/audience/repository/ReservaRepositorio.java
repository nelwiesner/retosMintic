package co.edu.usa.reto3.audience.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.reto3.audience.repository.crud.ReservaCrudRepositorio;
import co.edu.usa.reto3.audience.model.Reserva;
import co.edu.usa.reto3.audience.model.reportes.ConReservas;
import co.edu.usa.reto3.audience.model.Cliente;

@Repository
public class ReservaRepositorio {
    @Autowired
    ReservaCrudRepositorio reservaCrudRepositorio;
    public List<Reserva>getAll(){
        return (List<Reserva>)reservaCrudRepositorio.findAll();
    }
    public Optional<Reserva>getReserva(int id){
        return reservaCrudRepositorio.findById(id);
    }
    public Reserva save(Reserva reserva){
        return reservaCrudRepositorio.save(reserva);
    }

    public void delete(Reserva reserva){
        reservaCrudRepositorio.delete(reserva);
    }

    public List<Reserva> getReservasPorEstado(String estado){
        return reservaCrudRepositorio.findAllByEstado(estado);
    }

    public List<Reserva> getReservaFechas(Date fechaIni, Date fechaFin){
        return reservaCrudRepositorio.findAllByFechaInicioAfterAndFechaInicioBefore(fechaIni, fechaFin);
    }

    public List<ConReservas> getTopClientes(){
    List<ConReservas> res= new ArrayList<>();

    List<Object[]> reporte= reservaCrudRepositorio.countTotalReservasByClient();
    for (int i = 0; i < reporte.size(); i++) {
        res.add(new ConReservas((Long) reporte.get(i)[1], (Cliente) reporte.get(i)[0]));

    }
    return res;
    }
}
