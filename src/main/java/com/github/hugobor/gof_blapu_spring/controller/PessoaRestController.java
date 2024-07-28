package com.github.hugobor.gof_blapu_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.hugobor.gof_blapu_spring.model.Pessoa;
import com.github.hugobor.gof_blapu_spring.service.PessoaService;

@RestController
@RequestMapping("pessoas")
public class PessoaRestController {

	@Autowired
	private PessoaService pessoaService;


	@GetMapping
	public ResponseEntity<List<Pessoa>> buscarTodos() {
		return ResponseEntity.ok(pessoaService.buscaTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(pessoaService.buscaPorId(id));
	}

	@PostMapping
	public ResponseEntity<Pessoa> inserir(@RequestBody Pessoa Pessoa) {
		pessoaService.insere(Pessoa);
		return ResponseEntity.ok(Pessoa);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @RequestBody Pessoa Pessoa) {
		pessoaService.atualiza(id, Pessoa);
		return ResponseEntity.ok(Pessoa);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		pessoaService.deleta(id);
		return ResponseEntity.ok().build();
	}

}
