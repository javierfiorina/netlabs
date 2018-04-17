package main.java.gdc;

import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping(path="gdc/compra")
public class CompraController {
	@Autowired
	private CompraRepository compraRepository;
	private ProductoRepository productoRepository;

	public CompraController(CompraRepository compraRepository, ProductoRepository productoRepository) {
		this.compraRepository = compraRepository;
		this.productoRepository = productoRepository;
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseCustom comprar(@RequestBody Compra input) {
		try {
			Optional<Producto> prodOptional = productoRepository.findByNombre(input.getProductoNombre());
			if (!prodOptional.isPresent()) 
				return new ResponseCustom("No se encuentra el producto", 404);	
			
			Producto prod = prodOptional.get();
			if (prod.getStock() < input.getCantidad())
				return new ResponseCustom("No hay stock suficiente", 500);
			
			java.util.Date ahora = new java.util.Date();
			int precio = (prod.getPrecio() - getDescuento(prod.getNombre()))  * input.getCantidad();
			compraRepository.save(new Compra(ahora,input.getProductoNombre(),precio,input.getCantidad()));
			prod.setStock(prod.getStock() - input.getCantidad()); 
			productoRepository.save(prod);
			return new ResponseCustom("OK", 200);
		}catch(Exception e) {			
			return new ResponseCustom("Error: "+ e.toString(), 500);
		}		
	}
	
	@RequestMapping(method = RequestMethod.GET,produces="application/json")
	@ResponseBody
	public Collection<Compra> getCompras(@RequestBody Compra input) {
		 return compraRepository.findByFechaAndProductoNombreAndPrecio(input.getFecha(), input.getProductoNombre(), input.getPrecio());

	}
	
	private int getDescuento(String productoNombre) {
		String gddUrl =  System.getenv("GDD_URL");
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(gddUrl+"/"+productoNombre, int.class);
	}

	
	

}
