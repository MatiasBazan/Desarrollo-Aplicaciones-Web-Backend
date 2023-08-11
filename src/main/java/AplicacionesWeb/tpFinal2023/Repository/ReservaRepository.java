package AplicacionesWeb.tpFinal2023.Repository;

import AplicacionesWeb.tpFinal2023.Model.EspacioFisico;
import AplicacionesWeb.tpFinal2023.Model.Reserva;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.sql.Date;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    Page<Reserva> findByFechaInicioBetween(Date fechaInicio, Date fechaFin, Pageable pageable);



        @Query("SELECT r FROM Reserva r WHERE r.espacioFisico.id = :espacioId " +
                "AND r.fechaInicio <= :fin " +
                "AND r.fechaFin >= :inicio")
        List<Reserva> findOverlappingReservations(
                Long espacioId, String inicio, String fin);

    @Query("SELECT r FROM Reserva r WHERE (:solicitante is null OR CONCAT(r.solicitante.nombre,' ',r.solicitante.apellido) LIKE CONCAT('%', :solicitante, '%'))")
    List<Reserva> findByNombreSolicitanteOrApellidoSolicitante(
            String solicitante);
}

