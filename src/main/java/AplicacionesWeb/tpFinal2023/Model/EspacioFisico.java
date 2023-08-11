package AplicacionesWeb.tpFinal2023.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter

public class EspacioFisico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String nombre;

    @ManyToMany
    private List<Recurso> recursos;

    private Long capacidad;

    private String descripcion;


    public EspacioFisico(@NonNull String nombre, List<Recurso> recursos, String descripcion, Long capacidad) {
        this.nombre = nombre;
        this.recursos = recursos;
        this.capacidad = capacidad;
        this.descripcion = descripcion;
    }
}