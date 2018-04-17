package main.java.gdc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
        SpringApplication.run(main.java.gdc.Application.class, args);
    }
	
	@Bean
	public CommandLineRunner demo(ProductoRepository productoRepo, CompraRepository compraRepo, CategoriaRepository categoriaRepo) {
		return (args) -> {
			Categoria cat =new Categoria("Comestibles",10);
			categoriaRepo.save(cat);
			
			productoRepo.save(new Producto("Papas_Fritas",30,10,"Comestibles"));
			productoRepo.save(new Producto("Cheetos",50,10,"Comestibles"));
			productoRepo.save(new Producto("Doritos",60,10,"Comestibles"));
			
			// fetch all Productos
						log.info("Producto found with findAll():");
						log.info("-------------------------------");
						for (Producto producto : productoRepo.findAll()) {
							log.info(producto.getNombre().toString());
						}
						log.info("");
						java.util.Date ahora = new java.util.Date();
		 compraRepo.save(new Compra(ahora,"Papas_Fritas",30,1));
		 compraRepo.save(new Compra(ahora,"Cheetos",100,2));
		 compraRepo.save(new Compra(ahora,"Doritos",60,1));
						
						
		};
	}

}
