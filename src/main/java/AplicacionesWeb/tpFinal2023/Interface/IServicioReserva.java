package AplicacionesWeb.tpFinal2023.Interface;

import AplicacionesWeb.tpFinal2023.Model.Reserva;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

public interface IServicioReserva {
    Reserva saveReserva(Reserva reserva);

    List<Reserva> getReservas();

    Reserva getReserva(Long id);

    Reserva updateReserva(Long id, Reserva reserva);

    Long deleteReserva(Long id);

    Page<Reserva> getReservasByFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin, int page, int size);
}

