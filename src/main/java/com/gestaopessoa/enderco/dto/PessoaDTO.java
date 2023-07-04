package com.gestaopessoa.enderco.dto;

import com.gestaopessoa.enderco.entities.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {

    private String nome;
    private String dataNascimento;
    public PessoaDTO(Pessoa pessoa){
        nome = pessoa.getNome();
        dataNascimento = pessoa.getDataNascimento();
    }
}
