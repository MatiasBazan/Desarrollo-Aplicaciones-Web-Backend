package AplicacionesWeb.tpFinal2023.Controller;

import AplicacionesWeb.tpFinal2023.Interface.IServicioRecurso;
import AplicacionesWeb.tpFinal2023.Interface.IServicioSolicitante;
import AplicacionesWeb.tpFinal2023.Model.Recurso;
import AplicacionesWeb.tpFinal2023.Model.Solicitante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitantes")
@CrossOrigin
public class ControllerSolicitante {

    @Autowired
    IServicioSolicitante solicitanteService;

    @GetMapping
    public List<Solicitante> getSolicitantes(@RequestParam(required = false) String nombreFiltro,
                                             @RequestParam(required = false) String apellidoFiltro) {
        if (nombreFiltro != null && !nombreFiltro.isEmpty() &&
                apellidoFiltro != null && !apellidoFiltro.isEmpty()) {
            return solicitanteService.getSolicitantesPorNombreYApellido(nombreFiltro, apellidoFiltro);
        } else {
            return solicitanteService.getSolicitantes();
        }
    }
}
