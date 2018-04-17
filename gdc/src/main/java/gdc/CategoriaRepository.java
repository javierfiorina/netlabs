package main.java.gdc;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import main.java.gdc.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	Optional<Categoria> findByNombre(String nombre);

}