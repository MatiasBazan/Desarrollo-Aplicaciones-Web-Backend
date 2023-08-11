package AplicacionesWeb.tpFinal2023.Service;

import AplicacionesWeb.tpFinal2023.Interface.IServicioReserva;
import AplicacionesWeb.tpFinal2023.Model.EspacioFisico;
import AplicacionesWeb.tpFinal2023.Model.Reserva;
import AplicacionesWeb.tpFinal2023.Model.ReservaRequest;
import AplicacionesWeb.tpFinal2023.Model.Solicitante;
import AplicacionesWeb.tpFinal2023.Repository.EspacioFisicoRepository;
import AplicacionesWeb.tpFinal2023.Repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ServiceReserva implements IServicioReserva {

    private final ReservaRepository reservaRepository;
    private final ServiceEspacioFisico espacioFisicoService;
    private final ServiceSolicitante serviceSolicitante;
    @Autowired
    public ServiceReserva(ReservaRepository reservaRepository, ServiceEspacioFisico espacioFisicoService, ServiceSolicitante serviceSolicitante) {
        this.reservaRepository = reservaRepository;
        this.espacioFisicoService = espacioFisicoService;
        this.serviceSolicitante = serviceSolicitante;
    }


    @Override
    public Reserva saveReserva(ReservaRequest reserva) {
        Reserva newReserva = new Reserva();

        if(reserva.getEspacioFisico() > 0){
            EspacioFisico espacioFisico = this.espacioFisicoService.getEspacioFisico(reserva.getEspacioFisico());
            newReserva.setEspacioFisico(espacioFisico);

            if(!validarDisponibilidad(reserva.getFechaInicio(),reserva.getFechaFin(),espacioFisico)){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No hay disponibilidad para el espacio físico en esa fecha");
            }
        }
        if(reserva.getSolicitante() > 0){
            Solicitante solicitante = this.serviceSolicitante.getSolicitante(reserva.getSolicitante());
            newReserva.setSolicitante(solicitante);
        }
        newReserva.setFechaFin(reserva.getFechaFin());
        newReserva.setFechaInicio(reserva.getFechaInicio());

        return reservaRepository.save(newReserva);
    }

    public boolean validarDisponibilidad(String fechaInicio, String fechaFin, EspacioFisico espacioFisico) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        LocalDateTime inicio = LocalDateTime.parse(fechaInicio, formatter);
        LocalDateTime fin = LocalDateTime.parse(fechaFin, formatter);

        List<Reserva> reservasSuperpuestas = reservaRepository
                .findOverlappingReservations(
                        espacioFisico.getId(),
                        inicio.format(formatter),
                        fin.format(formatter));

        return reservasSuperpuestas.isEmpty();
    }

    @Override
    public List<Reserva> getReservas() {
        return reservaRepository.findAll();
    }

    @Override
    public List<Reserva> getReservasBySolicitante(String solicitante) {
        return reservaRepository.findByNombreSolicitanteOrApellidoSolicitante(solicitante);
    }

    @Override
    public Reserva getReserva(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    @Override
    public Reserva updateReserva(Long id, ReservaRequest reservaRequest) {
        Reserva reserva = getReserva(id);


        if(reservaRequest.getEspacioFisico() > 0){
            EspacioFisico espacioFisico = this.espacioFisicoService.getEspacioFisico(reservaRequest.getEspacioFisico());
            reserva.setEspacioFisico(espacioFisico);

            if(!validarDisponibilidad(reservaRequest.getFechaInicio(),reservaRequest.getFechaFin(),espacioFisico)){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No hay disponibilidad para el espacio físico en esa fecha");
            }
        }

        if(reservaRequest.getSolicitante() > 0){
            Solicitante solicitante = this.serviceSolicitante.getSolicitante(reservaRequest.getSolicitante());
            reserva.setSolicitante(solicitante);
        }
        reserva.setFechaFin(reservaRequest.getFechaFin());
        reserva.setFechaInicio(reservaRequest.getFechaInicio());

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
