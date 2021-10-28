package co.edu.usa.reto3.audience.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.reto3.audience.repository.crud.ReservaCrudRepositorio;
import co.edu.usa.reto3.audience.model.Reserva;

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
    public Reserva save(Reserva dpto){
        return reservaCrudRepositorio.save(dpto);
    }
}
