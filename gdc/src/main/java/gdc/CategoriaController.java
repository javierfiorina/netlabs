package main.java.gdc;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="gdc/categoria")
public class CategoriaController {
	@Autowired
	private CategoriaRepository categoriaRepository;

	public CategoriaController(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseCustom modificarCategoria(@RequestBody Categoria input) {
		try {
			Optional<Categoria> categoriaOpt = categoriaRepository.findByNombre(input.getNombre());
			if (!categoriaOpt.isPresent()) 
				return new ResponseCustom("No se encuentra el producto", 404);	
			
			Categoria categoria = categoriaOpt.get();
			categoria.setUmbral(input.getUmbral());
			categoriaRepository.save(categoria);
			return new ResponseCustom("OK", 200);
		}catch(Exception e) {			
			return new ResponseCustom("Error: "+ e.toString(), 500);
		}		
		
	}
}
