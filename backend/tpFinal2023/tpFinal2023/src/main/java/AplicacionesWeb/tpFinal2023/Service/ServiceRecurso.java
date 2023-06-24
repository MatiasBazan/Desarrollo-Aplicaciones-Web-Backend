package AplicacionesWeb.tpFinal2023.Service;

import AplicacionesWeb.tpFinal2023.Interface.IServicioRecurso;
import AplicacionesWeb.tpFinal2023.Model.Recursos;
import AplicacionesWeb.tpFinal2023.Repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Optional;

public class ServiceRecurso implements IServicioRecurso {
    @Autowired
    RecursoRepository recursoRepository;

    @Override
    public Optional<Recursos> findById(Long id) {
        return recursoRepository.findById(id);
    }



}
