package org.generation.techdelas.repository;

import java.util.List;

import org.generation.techdelas.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository  extends JpaRepository <Postagem, Long> {
	
	
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);
	
	public List<Postagem> findAllByTextoContainingIgnoreCase(String texto);

}
