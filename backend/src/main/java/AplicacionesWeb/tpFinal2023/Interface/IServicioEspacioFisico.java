package AplicacionesWeb.tpFinal2023.Interface;

import AplicacionesWeb.tpFinal2023.Model.EspacioFisico;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IServicioEspacioFisico {


    EspacioFisico saveEspacioFisico(EspacioFisico espacioFisico);

    List<EspacioFisico> getEspaciosFisicos();

    EspacioFisico getEspacioFisico(Long id);

    EspacioFisico updateEspacioFisico(Long id, EspacioFisico e);

    Long deleteEspacioFisico(Long id);

    Page<EspacioFisico> getFiltroNombreAndCapacidad(String nombre, Long capacidad, int page , int size);

}
