package main.java.gdc;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="gdc/productos") 
public class ProductoController {
	@Autowired
	private ProductoRepository productoRepository;

	ProductoController(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}

	@RequestMapping(method = RequestMethod.GET, produces="application/json")
	public @ResponseBody Collection<Producto> listAllProducto() {
		return this.productoRepository.findAll();
	}
	
}
