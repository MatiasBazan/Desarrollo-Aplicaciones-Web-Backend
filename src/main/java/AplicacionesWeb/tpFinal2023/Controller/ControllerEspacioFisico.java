package AplicacionesWeb.tpFinal2023.Controller;

import AplicacionesWeb.tpFinal2023.Interface.IServicioEspacioFisico;
import AplicacionesWeb.tpFinal2023.Model.EspacioFisico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/espacioFisico")
@CrossOrigin
public class ControllerEspacioFisico {

    @Autowired
    IServicioEspacioFisico espacioFisicoService;
    private ControllerEspacioFisico servicio;

    @PostMapping
    public EspacioFisico saveEspacioFisico(@RequestBody EspacioFisico espacioFisico) {
        return espacioFisicoService.saveEspacioFisico(espacioFisico);
    }

    @GetMapping
    public List<EspacioFisico> getEspaciosFisicos() {
        return espacioFisicoService.getEspaciosFisicos();
    }

    @GetMapping("/{id}")
    public EspacioFisico getEspacioFisico(@PathVariable Long id) {
        return espacioFisicoService.getEspacioFisico(id);
    }

    @PutMapping("/{id}")
    public EspacioFisico update(@PathVariable Long id, @RequestBody EspacioFisico r) {
        return espacioFisicoService.updateEspacioFisico(id, r);
    }

    @DeleteMapping("/{id}")
    public Long deleteEspacioFisico(@PathVariable Long id) {

        return espacioFisicoService.deleteEspacioFisico(id);
    }
    @GetMapping(params ={"nombre","capacidad"})
    public List<EspacioFisico> getFiltroNombreAndCapacidad(@RequestParam("nombre") String nombre,
                                                           @RequestParam("capacidad") Long capacidad) {

        return espacioFisicoService.getFiltroNombreAndCapacidad(nombre, capacidad);
    }
    @GetMapping(params ={"nombre"})
    public List<EspacioFisico> getFiltroNombre(@RequestParam("nombre") String nombre) {

        return espacioFisicoService.getFiltroNombre(nombre);
    }

    @GetMapping(params ={"capacidad"})
    public List<EspacioFisico> getFiltroCapacidad(@RequestParam("capacidad") Long capacidad) {

        return espacioFisicoService.getFiltroCapacidad(capacidad);
    }
}


