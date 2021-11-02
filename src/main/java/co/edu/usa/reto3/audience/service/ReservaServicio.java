package co.edu.usa.reto3.audience.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.usa.reto3.audience.model.Reserva;
import co.edu.usa.reto3.audience.repository.ReservaRepositorio;

@Service
public class ReservaServicio {
    @Autowired
    private ReservaRepositorio reservaRepositorio;

    public List<Reserva>getAll(){
        return reservaRepositorio.getAll();
    }

    public Optional<Reserva>getReserva(int id){
        return reservaRepositorio.getReserva(id);
    }

    public Reserva save(Reserva reserva){
        //Verificar si el id es nulo
        if(reserva.getidReservation()==null){
            return reservaRepositorio.save(reserva);
        }else{//Verifico si existe o no en la base de datos
            Optional<Reserva> consulta=reservaRepositorio.getReserva(reserva.getidReservation());
            if (consulta.isEmpty()){
                return reservaRepositorio.save(reserva);
            }else{
                return reserva;
            }
        }   
    }
}
