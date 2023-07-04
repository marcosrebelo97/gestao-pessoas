package com.gestaopessoa.enderco.DTO;

import com.gestaopessoa.enderco.Entities.Pessoa;
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
