package gdd;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/gdd/{productoNombre}")
public class DescuentoController {
	@Autowired
	private DescuentoRepository descuentoRepository;

	public DescuentoController(DescuentoRepository descuentoRepository) {
		this.descuentoRepository = descuentoRepository;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public long getDescuento(@PathVariable String productoNombre) {
		Optional<Descuento> descuentoOpional = descuentoRepository.findByProductoNombre(productoNombre);
		if (!descuentoOpional.isPresent())
			return 0;
		return descuentoOpional.get().getDescuento();
	}

}
