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
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String telefono;
    private String fechaInicio;
    private String fechaFin;
}

