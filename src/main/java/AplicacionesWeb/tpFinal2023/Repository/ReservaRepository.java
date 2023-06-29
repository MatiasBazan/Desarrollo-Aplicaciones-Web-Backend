package AplicacionesWeb.tpFinal2023.Repository;

import AplicacionesWeb.tpFinal2023.Model.Reserva;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    Page<Reserva> findByFechaInicioBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin, Pageable pageable);
}

