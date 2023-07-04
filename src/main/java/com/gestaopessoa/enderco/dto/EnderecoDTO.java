package com.gestaopessoa.enderco.dto;

import com.gestaopessoa.enderco.entities.Endereco;
import com.gestaopessoa.enderco.entities.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EnderecoDTO {
    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;

    private Pessoa pessoa;
    public void Pessoa(Pessoa id){
    }

    public EnderecoDTO(Endereco endereco){
        logradouro = endereco.getLogradouro();
        cep = endereco.getCep();
        numero = endereco.getNumero();
        cidade = endereco.getCidade();
    }


}
