package AplicacionesWeb.tpFinal2023.Service;

import AplicacionesWeb.tpFinal2023.Interface.IServicioEspacioFisico;
import AplicacionesWeb.tpFinal2023.Model.EspacioFisico;
import AplicacionesWeb.tpFinal2023.Repository.EspacioFisicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ServiceEspacioFisico implements IServicioEspacioFisico {
    @Autowired
    EspacioFisicoRepository espacioFisicoRepository;


    @Override
    public EspacioFisico saveEspacioFisico(EspacioFisico espacioFisico) {
        return espacioFisicoRepository.save(new EspacioFisico(espacioFisico.getNombre(),espacioFisico.getRecursos(),espacioFisico.getDescripcion(),espacioFisico.getCapacidad()));
    }

    @Override
    public List<EspacioFisico> getEspaciosFisicos() {
        return espacioFisicoRepository.findAll();
    }

    @Override
    public EspacioFisico getEspacioFisico(Long id) {
        return espacioFisicoRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró el espacio físico id "+id+" .")
        );
    }
    @Override
    public EspacioFisico updateEspacioFisico(Long id, EspacioFisico e) {
        EspacioFisico espacioFisico = getEspacioFisico(id);
        espacioFisico.setNombre(e.getNombre());
        espacioFisico.setRecursos(e.getRecursos());

        return espacioFisicoRepository.save(espacioFisico);
    }

    @Override
    public Long deleteEspacioFisico(Long id) {
        espacioFisicoRepository.deleteById(id);
        return id;
    }

    @Override
    public Page<EspacioFisico> getFiltroNombreAndCapacidad (String nombre, Long capacidad, int page , int size) {
        Pageable pageable = PageRequest.of(page, size);
        return espacioFisicoRepository.findAllByNombreAndCapacidad(nombre,capacidad, pageable);
    }
}
