package AplicacionesWeb.tpFinal2023.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private EspacioFisico espacioFisico;

    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

    public Reserva(EspacioFisico espacioFisico, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        this.espacioFisico = espacioFisico;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
}

