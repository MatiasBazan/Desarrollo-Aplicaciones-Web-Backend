package AplicacionesWeb.tpFinal2023.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ReservaRequest {

    private Long espacioFisico;
    private Long solicitante;
    private String fechaInicio;
    private String fechaFin;
}

