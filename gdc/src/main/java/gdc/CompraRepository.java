package main.java.gdc;

import java.util.Collection;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.java.gdc.Compra;
@Repository
public interface CompraRepository extends JpaRepository<Compra, Long>  {
	Collection<Compra> findByFechaAndProductoNombreAndPrecio( Date fecha, String productoNombre, int precio);

}
