package AplicacionesWeb.tpFinal2023.Service;

import AplicacionesWeb.tpFinal2023.Interface.IServicioRecurso;
import AplicacionesWeb.tpFinal2023.Model.Recurso;
import AplicacionesWeb.tpFinal2023.Repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ServiceRecurso implements IServicioRecurso {
    @Autowired
    RecursoRepository recursoRepository;

    @Override
    public Optional<Recurso> findById(Long id) {
        return recursoRepository.findById(id);
    }

    @Override
    public List<Recurso> getRecursosTecnologicos() {
        return recursoRepository.findAll();
    }


}
