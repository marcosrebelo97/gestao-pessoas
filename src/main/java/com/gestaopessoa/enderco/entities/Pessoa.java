package com.gestaopessoa.enderco.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestaopessoa.enderco.dto.PessoaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "tb_pessoa")
@Entity
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	private String nome;
	private String dataNascimento;

	@JsonIgnore
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
	private Set<Endereco> enderecos = new HashSet<>();

	public Pessoa(PessoaDTO novapessoa) {
		nome = novapessoa.getNome();
		dataNascimento = novapessoa.getDataNascimento();
	}

}
