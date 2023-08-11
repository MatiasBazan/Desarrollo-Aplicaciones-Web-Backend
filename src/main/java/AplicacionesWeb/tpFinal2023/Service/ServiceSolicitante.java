package AplicacionesWeb.tpFinal2023.Service;

import AplicacionesWeb.tpFinal2023.Interface.IServicioSolicitante;
import AplicacionesWeb.tpFinal2023.Model.Solicitante;
import AplicacionesWeb.tpFinal2023.Repository.SolicitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceSolicitante implements IServicioSolicitante {

    @Autowired
    SolicitanteRepository solicitanteRepository;

    @Override
    public Optional<Solicitante> findById(Long id) {
        return solicitanteRepository.findById(id);
    }

    @Override
    public List<Solicitante> getSolicitantes() {
        return solicitanteRepository.findAll();
    }

    @Override
    public Solicitante getSolicitante(Long id) {
        return solicitanteRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró el solicitante id " + id + ".")
        );
    }

    @Override
    public List<Solicitante> getSolicitantesPorNombreYApellido(String nombre, String apellido) {
        return solicitanteRepository.findByNombreAndApellido(nombre, apellido);
    }
}
