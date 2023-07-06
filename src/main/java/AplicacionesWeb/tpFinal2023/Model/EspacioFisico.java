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
    private List<Recursos> recursos;

    private Long capacidad;

    private String descripcion;

    /*@ManyToOne
    private EstadoEspacioFisico estado;*/

    public EspacioFisico(@NonNull String nombre, List<Recursos> recursos, String descripcion ,Long capacidad ) {
        this.nombre = nombre;
        this.recursos = recursos;
        //this.estado = estado;
        this.capacidad = capacidad;
        this.descripcion = descripcion;
    }
}