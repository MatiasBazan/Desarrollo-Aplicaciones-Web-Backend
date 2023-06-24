package AplicacionesWeb.tpFinal2023.Repository;

import AplicacionesWeb.tpFinal2023.Model.Recursos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RecursoRepository extends JpaRepository<Recursos, Long> {

}
