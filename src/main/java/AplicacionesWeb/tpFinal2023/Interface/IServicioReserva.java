package AplicacionesWeb.tpFinal2023.Interface;

import AplicacionesWeb.tpFinal2023.Model.Reserva;
import AplicacionesWeb.tpFinal2023.Model.ReservaRequest;
import org.springframework.data.domain.Page;


import java.sql.Date;
import java.util.List;

public interface IServicioReserva {
    Reserva saveReserva(ReservaRequest reserva);

    List<Reserva> getReservas();

    Reserva getReserva(Long id);

    Reserva updateReserva(Long id, Reserva reserva);

    Long deleteReserva(Long id);

    Page<Reserva> getReservasByFecha(Date fechaInicio, Date fechaFin, int page, int size);
}

