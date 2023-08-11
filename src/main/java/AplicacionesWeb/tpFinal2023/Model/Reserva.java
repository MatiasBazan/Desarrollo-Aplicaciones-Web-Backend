package AplicacionesWeb.tpFinal2023.Model;

import jakarta.persistence.*;
import lombok.*;


import java.sql.Date;

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
    @ManyToOne
    private Solicitante solicitante;

    private String fechaInicio;
    private String fechaFin;

    public Reserva(EspacioFisico espacioFisico,String fechaInicio, String fechaFin, Solicitante solicitante ) {
        this.espacioFisico = espacioFisico;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.solicitante = solicitante;
    }
}

