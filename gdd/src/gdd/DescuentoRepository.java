package gdd;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import gdd.Descuento;

public interface DescuentoRepository extends JpaRepository<Descuento, Long> {
	
	Optional<Descuento> findByProductoNombre(String productoNombre);

}
