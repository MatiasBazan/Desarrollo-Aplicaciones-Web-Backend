package AplicacionesWeb.tpFinal2023.Interface;

import AplicacionesWeb.tpFinal2023.Model.Recursos;

import java.util.Optional;

public interface IServicioRecurso {

    Optional<Recursos> findById(Long id);


}
