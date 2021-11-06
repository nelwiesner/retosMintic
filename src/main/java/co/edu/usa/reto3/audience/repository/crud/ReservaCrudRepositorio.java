package co.edu.usa.reto3.audience.repository.crud;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import co.edu.usa.reto3.audience.model.Reserva;

public interface ReservaCrudRepositorio extends CrudRepository<Reserva,Integer>{

    //JPQL
    @Query("select e.client, COUNT(e.client)  from Reserva as e group by e.client order by COUNT(e.client) desc")
    public List<Object[]> countTotalReservasByClient();


    //Query Methods
    public List<Reserva> findAllByStartDateAfterAndStartDateBefore(Date fechIni, Date fechaFin);

    public List<Reserva> findAllByEstado(String estado);


}
