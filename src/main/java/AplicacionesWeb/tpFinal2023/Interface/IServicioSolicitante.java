package AplicacionesWeb.tpFinal2023.Interface;

import AplicacionesWeb.tpFinal2023.Model.EspacioFisico;
import AplicacionesWeb.tpFinal2023.Model.Recurso;
import AplicacionesWeb.tpFinal2023.Model.Solicitante;

import java.util.List;
import java.util.Optional;

public interface IServicioSolicitante {

    Optional<Solicitante> findById(Long id);

    List<Solicitante> getSolicitantes();

    Solicitante getSolicitante(Long id);

    List<Solicitante> getSolicitantesPorNombreYApellido(String nombreFiltro, String apellidoFiltro);
}




