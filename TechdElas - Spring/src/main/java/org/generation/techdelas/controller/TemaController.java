package org.generation.techdelas.controller;

import java.util.List;

import javax.validation.Valid;

import org.generation.techdelas.model.Tema;
import org.generation.techdelas.repository.TemaRepository;
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
@RequestMapping("/tema") // Mapeia todas URLs de solicitações HTTP
@CrossOrigin("*") // "leitor de linguagem"
public class TemaController {

	@Autowired
	private TemaRepository temaRepository;

	@GetMapping
	public ResponseEntity<List<Tema>> getAll() {
		return ResponseEntity.ok(temaRepository.findAll());

	}

	@GetMapping("/{idTema}") // Pegar o Id

	public ResponseEntity<Tema> getAll(@PathVariable long idTema) {
		return temaRepository.findById(idTema).map(resp -> ResponseEntity.ok(resp)) // Mapeia as informações
				.orElse(ResponseEntity.notFound().build()); // Retorna o erro 404

	}

	@GetMapping("/descricao/{descricao}") // Pegar a descrição do Tema
	public ResponseEntity<List<Tema>> getByDescricao(@PathVariable String descricao) { // List<Tema> = listará os
																						// registros da tabela
		return ResponseEntity.ok(temaRepository.findAllByDescricaoContainingIgnoreCase(descricao)); // ResponseEntity =
																									// Usado para
																									// configurar toda a
																									// resposta HTTP
	}

	@PostMapping
	public ResponseEntity<Tema> post(@Valid @RequestBody Tema tema) {
		return ResponseEntity.status(HttpStatus.CREATED).body(temaRepository.save(tema));
	}

	@PutMapping
	public ResponseEntity<Tema> put(@Valid @RequestBody Tema tema) {
		return temaRepository.findById(tema.getIdTema()).map(resp -> {
			return ResponseEntity.ok().body(temaRepository.save(tema));
		}).orElse(ResponseEntity.notFound().build());

	}

	@DeleteMapping("/{idTema}")
	public ResponseEntity<?> delete(@PathVariable long idTema) {
		return temaRepository.findById(idTema).map(resp -> {
			temaRepository.deleteById(idTema);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		})

				.orElse(ResponseEntity.notFound().build());
	}

}
