package AplicacionesWeb.tpFinal2023.Controller;

import AplicacionesWeb.tpFinal2023.Interface.IServicioEspacioFisico;
import AplicacionesWeb.tpFinal2023.Interface.IServicioRecurso;
import AplicacionesWeb.tpFinal2023.Model.Recurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/recursos")
@CrossOrigin
public class ControllerRecurso {

    @Autowired
    IServicioRecurso recursoService;

    @GetMapping
    public List<Recurso> getRecursosTecnologicos() {
        return recursoService.getRecursosTecnologicos();
    }
}
