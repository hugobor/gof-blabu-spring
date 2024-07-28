package com.github.hugobor.gof_blapu_spring.service;

import java.util.List;

import com.github.hugobor.gof_blapu_spring.model.Pessoa;

public interface PessoaService {
	
	List<Pessoa> buscaTodos();
	
	Pessoa buscaPorId(Long id);
	
	void insere(Pessoa pessoa);
	
	void atualiza(Long id, Pessoa Pessoa);
	
	void deleta(Long id);
	
}
