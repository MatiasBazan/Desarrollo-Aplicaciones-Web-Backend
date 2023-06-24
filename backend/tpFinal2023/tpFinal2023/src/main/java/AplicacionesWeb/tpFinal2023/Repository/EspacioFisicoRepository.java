package AplicacionesWeb.tpFinal2023.Repository;

import AplicacionesWeb.tpFinal2023.Model.EspacioFisico;
import AplicacionesWeb.tpFinal2023.Model.Recursos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EspacioFisicoRepository  extends JpaRepository<EspacioFisico, Long> {

    Page<EspacioFisico> findAllByNombreAndCapacidad(String nombre, Long capacidad, Pageable pageable);

}
