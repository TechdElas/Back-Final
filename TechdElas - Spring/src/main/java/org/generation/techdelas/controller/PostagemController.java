package org.generation.techdelas.controller;

import java.util.List;

import javax.validation.Valid;

import org.generation.techdelas.model.Postagem;
import org.generation.techdelas.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagens") // Mapeia todas URLs de solicitações HTTP
@CrossOrigin(origins = "*", allowedHeaders = "*") // "leitor de linguagem"
public class PostagemController {

	@Autowired
	private PostagemRepository postagemRepository;

	@GetMapping
	public ResponseEntity<List<Postagem>> getAll() {
		return ResponseEntity.ok(postagemRepository.findAll());

	}

	@GetMapping("/{idPostagem}")
	public ResponseEntity<Postagem> getAll(@PathVariable long idPostagem) {
		return postagemRepository.findById(idPostagem).map(resp -> ResponseEntity.ok(resp)) // Mapeia as informações
				.orElse(ResponseEntity.notFound().build());

	}

	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo) { // List<Tema> = listará os
		return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo)); // registros da tabela

	}

	@GetMapping("/texto/{texto}")
	public ResponseEntity<List<Postagem>> getByTexto(@PathVariable String texto) {
		return ResponseEntity.ok(postagemRepository.findAllByTextoContainingIgnoreCase(texto));
	}

	@PostMapping // Atua como atalho para o request, lidando apenas com solicitações do tipo HTTP
	public ResponseEntity<Postagem> postPostagem(@Valid @RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));
	}

	@PutMapping
	public ResponseEntity<Postagem> putPostagem(@Valid @RequestBody Postagem postagem) {
		return postagemRepository.findById(postagem.getIdPostagem())
				.map(resp -> ResponseEntity.ok().body(postagemRepository.save(postagem)))
				.orElse(ResponseEntity.notFound().build());

	}

	@DeleteMapping("/{idPostagem}")
	public ResponseEntity<?> deletePostagem(@PathVariable long idPostagem) {
		return postagemRepository.findById(idPostagem).map(resp -> {
			postagemRepository.deleteById(idPostagem);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}).orElse(ResponseEntity.notFound().build());

	}

}
