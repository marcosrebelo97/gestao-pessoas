package com.gestaopessoa.enderco.dto;

import com.gestaopessoa.enderco.entities.Endereco;
import com.gestaopessoa.enderco.entities.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaEnderecoDTO {
    private String nome;
    private String dataNascimento;
    private Set<Endereco> enderecos;

    public PessoaEnderecoDTO(Pessoa pessoa){
        nome = pessoa.getNome();
        dataNascimento = pessoa.getDataNascimento();
        enderecos = pessoa.getEnderecos();
    }
}
