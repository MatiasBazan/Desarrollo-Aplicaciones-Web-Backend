package AplicacionesWeb.tpFinal2023.Service;

import AplicacionesWeb.tpFinal2023.Interface.IServicioReserva;
import AplicacionesWeb.tpFinal2023.Model.Reserva;
import AplicacionesWeb.tpFinal2023.Repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServiceReserva implements IServicioReserva {

    private final ReservaRepository reservaRepository;

    @Autowired
    public ServiceReserva(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }


    @Override
    public Reserva saveReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Override
    public List<Reserva> getReservas() {
        return reservaRepository.findAll();
    }

    @Override
    public Reserva getReserva(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    @Override
    public Reserva updateReserva(Long id, Reserva reserva) {
        reserva.setId(id);
        return reservaRepository.save(reserva);
    }

    @Override
    public Long deleteReserva(Long id) {
        reservaRepository.deleteById(id);
        return id;
    }

    @Override
    public Page<Reserva> getReservasByFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin, int page, int size) {
        return reservaRepository.findByFechaInicioBetween(fechaInicio, fechaFin, PageRequest.of(page, size));
    }
}
