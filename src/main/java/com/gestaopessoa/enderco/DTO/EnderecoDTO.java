package com.gestaopessoa.enderco.DTO;

import com.gestaopessoa.enderco.Entities.Endereco;
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

    public EnderecoDTO(Endereco endereco){
        logradouro = endereco.getLogradouro();
        cep = endereco.getCep();
        numero = endereco.getNumero();
        cidade = endereco.getCidade();
    }

}
