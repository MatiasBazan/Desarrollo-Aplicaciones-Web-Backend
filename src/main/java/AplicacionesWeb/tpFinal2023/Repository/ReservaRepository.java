package AplicacionesWeb.tpFinal2023.Repository;

import AplicacionesWeb.tpFinal2023.Model.Reserva;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    Page<Reserva> findByFechaInicioBetween(Date fechaInicio, Date fechaFin, Pageable pageable);
}

