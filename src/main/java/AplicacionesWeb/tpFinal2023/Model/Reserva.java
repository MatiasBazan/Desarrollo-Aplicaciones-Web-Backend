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

    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String telefono;
    private String fechaInicio;
    private String fechaFin;

    public Reserva(EspacioFisico espacioFisico, String nombre, String apellido, String dni, String email, String telefono,String fechaInicio, String fechaFin ) {
        this.espacioFisico = espacioFisico;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
}

