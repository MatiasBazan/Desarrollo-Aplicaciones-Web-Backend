package AplicacionesWeb.tpFinal2023.Repository;

import AplicacionesWeb.tpFinal2023.Model.EspacioFisico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EspacioFisicoRepository  extends JpaRepository<EspacioFisico, Long> {

    List<EspacioFisico> findByNombreIgnoreCaseContainsAndCapacidad(String nombre, Long capacidad);

    List<EspacioFisico> findByNombreIgnoreCaseContains(String nombre);

    List<EspacioFisico> findByCapacidad(Long capacidad);

}
