package co.edu.usa.reto3.audience.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.reto3.audience.model.Reserva;
import co.edu.usa.reto3.audience.model.reportes.ConEstadosReservas;
import co.edu.usa.reto3.audience.model.reportes.ConReservas;
import co.edu.usa.reto3.audience.repository.ReservaRepositorio;

@Service
public class ReservaServicio {
    @Autowired
    private ReservaRepositorio reservaRepositorio;

    public List<Reserva> getAll() {
        return reservaRepositorio.getAll();
    }

    public Optional<Reserva> getReserva(int id) {
        return reservaRepositorio.getReserva(id);
    }

    public Reserva save(Reserva reserva) {
        // Verificar si el id es nulo
        if (reserva.getIdReservation() == null) {
            return reservaRepositorio.save(reserva);
        } else {// Verifico si existe o no en la base de datos
            Optional<Reserva> consulta = reservaRepositorio.getReserva(reserva.getIdReservation());
            if (consulta.isEmpty()) {
                return reservaRepositorio.save(reserva);
            } else {
                return reserva;
            }
        }
    }

    public Reserva update(Reserva reserva) {
        if (reserva.getIdReservation() != null) {
            Optional<Reserva> consulta = reservaRepositorio.getReserva(reserva.getIdReservation());
            if (!consulta.isEmpty()) {
                if (reserva.getStartDate() != null) {
                    consulta.get().setStartDate(reserva.getStartDate());
                }
                if (reserva.getDevolutionDate() != null) {
                    consulta.get().setDevolutionDate(reserva.getDevolutionDate());
                }
                if (reserva.getStatus() != null) {
                    consulta.get().setStatus(reserva.getStatus());
                }

                return reservaRepositorio.save(consulta.get());
            }
        }
        return reserva;
    }

    public boolean deleteReserva(int idReservation) {
        Optional<Reserva> consulta = reservaRepositorio.getReserva(idReservation);
        if (!consulta.isEmpty()) {
            reservaRepositorio.delete(consulta.get());
            return true;

        }
        return false;
    }

    public List<ConReservas> getTopClientes() {
        return reservaRepositorio.getTopClientes();

    }

    public ConEstadosReservas getReporteEstados() {
        List<Reserva> activos = reservaRepositorio.getReservasPorEstado("Completadas");
        List<Reserva> inactivos = reservaRepositorio.getReservasPorEstado("Canceladas");

        ConEstadosReservas reporteEstado = new ConEstadosReservas(activos.size(), inactivos.size());

        return reporteEstado;
    }

    public List<Reserva> getReservaFechas(String fecha1, String fecha2) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaIni = new Date();
        Date fechaFin = new Date();

        try {
            fechaIni = formato.parse(fecha1);
            fechaFin = formato.parse(fecha2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (fechaIni.before(fechaFin)) {
            return reservaRepositorio.getReservaFechas(fechaIni, fechaFin);

        } else {
            return new ArrayList<>();

        }
    }
}
