package AplicacionesWeb.tpFinal2023.Service;

import AplicacionesWeb.tpFinal2023.Interface.IServicioReserva;
import AplicacionesWeb.tpFinal2023.Model.EspacioFisico;
import AplicacionesWeb.tpFinal2023.Model.Reserva;
import AplicacionesWeb.tpFinal2023.Model.ReservaRequest;
import AplicacionesWeb.tpFinal2023.Repository.EspacioFisicoRepository;
import AplicacionesWeb.tpFinal2023.Repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ServiceReserva implements IServicioReserva {

    private final ReservaRepository reservaRepository;
    private final ServiceEspacioFisico espacioFisicoService;
    @Autowired
    public ServiceReserva(ReservaRepository reservaRepository, ServiceEspacioFisico espacioFisicoService) {
        this.reservaRepository = reservaRepository;
        this.espacioFisicoService = espacioFisicoService;
    }


    @Override
    public Reserva saveReserva(ReservaRequest reserva) {
        Reserva newReserva = new Reserva();

        if(reserva.getEspacioFisico() > 0){
            EspacioFisico espacioFisico = this.espacioFisicoService.getEspacioFisico(reserva.getEspacioFisico());
            newReserva.setEspacioFisico(espacioFisico);
        }
        newReserva.setNombre(reserva.getNombre());
        newReserva.setApellido(reserva.getApellido());
        newReserva.setDni(reserva.getDni());
        newReserva.setEmail(reserva.getEmail());
        newReserva.setTelefono(reserva.getTelefono());
        newReserva.setFechaFin(reserva.getFechaFin());
        newReserva.setFechaInicio(reserva.getFechaInicio());

        return reservaRepository.save(newReserva);
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
    public Page<Reserva> getReservasByFecha(Date fechaInicio, Date fechaFin, int page, int size) {
        return reservaRepository.findByFechaInicioBetween(fechaInicio, fechaFin, PageRequest.of(page, size));
    }
}
