package com.github.hugobor.gof_blapu_spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Entity
public class Pessoa {
	
	@Repository
	public static interface PessoaRepository extends CrudRepository<Pessoa, Long> {
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	@ManyToOne
	private Endereco endereco;

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }

	public Endereco getEndereco() {	return endereco; }
	public void setEndereco(Endereco endereco) { this.endereco = endereco; }

}
