package com.gestaopessoa.enderco.DTO;

import com.gestaopessoa.enderco.Entities.Endereco;
import com.gestaopessoa.enderco.Entities.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
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
