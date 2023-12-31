package AplicacionesWeb.tpFinal2023.Controller;

import AplicacionesWeb.tpFinal2023.Interface.IServicioReserva;
import AplicacionesWeb.tpFinal2023.Model.Reserva;
import AplicacionesWeb.tpFinal2023.Model.ReservaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reserva")
@CrossOrigin
public class ControllerReserva {

    @Autowired
    private IServicioReserva reservaService;

    @PostMapping
    public Reserva saveReserva(@RequestBody ReservaRequest reserva) {
        return reservaService.saveReserva(reserva);
    }

    @GetMapping(params ={"Solicitante"})
    public List<Reserva> getReservas(@RequestParam(required = false) String Solicitante) {
        return reservaService.getReservasBySolicitante(Solicitante);
    }
    @GetMapping()
    public List<Reserva> getReservas() {
        return reservaService.getReservas();
    }

    @GetMapping("/{id}")
    public Reserva getReserva(@PathVariable Long id) {
        return reservaService.getReserva(id);
    }

    @PutMapping("/{id}")
    public Reserva updateReserva(@PathVariable Long id, @RequestBody ReservaRequest reserva) {
        return reservaService.updateReserva(id, reserva);
    }

    @DeleteMapping("/{id}")
    public Long deleteReserva(@PathVariable Long id) {
        return reservaService.deleteReserva(id);
    }

}
