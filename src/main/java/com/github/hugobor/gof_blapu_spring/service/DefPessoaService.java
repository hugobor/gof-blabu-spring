package com.github.hugobor.gof_blapu_spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.hugobor.gof_blapu_spring.model.Endereco;
import com.github.hugobor.gof_blapu_spring.model.EnderecoRepository;
import com.github.hugobor.gof_blapu_spring.model.Pessoa;
import com.github.hugobor.gof_blapu_spring.model.PessoaRepository;


@Service
public class DefPessoaService implements PessoaService {

	@Autowired
	public PessoaRepository pessoaRepository;
	
	@Autowired
	public EnderecoRepository enderecoRepository;
	
	@Autowired
	public ViaCepService viaCepService;
	
	
	@Override
	public Iterable<Pessoa> buscaTodos() {
		return pessoaRepository.findAll();
	}

	@Override
	public Pessoa buscaPorId(Long id) {
		return pessoaRepository.findById(id).orElse(null);
	}

	@Override
	public void insere(Pessoa pessoa) {
		String cep = pessoa.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			var novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});

		pessoa.setEndereco(endereco);
		pessoaRepository.save(pessoa);
	}

	@Override
	public void atualiza(Long id, Pessoa Pessoa) {
		pessoaRepository.findById(id).ifPresent(pessoa -> salvarPessoaComCep(pessoa));		
	}

	@Override
	public void deleta(Long id) {
		pessoaRepository.deleteById(id);		
	}
	private void salvarPessoaComCep(Pessoa pessoa) {
		String cep = pessoa.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		pessoa.setEndereco(endereco);
		pessoaRepository.save(pessoa);
	}
}
