package com.gestaopessoa.enderco.dto;

import com.gestaopessoa.enderco.projections.PessoaEnderecoPrincipalProjections;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoPrincipalDTO {
    private String nome;
    private String dataNascimento;
    private EnderecoDTO enderecoPrincipal = new EnderecoDTO();

    public EnderecoPrincipalDTO(PessoaEnderecoPrincipalProjections projections){
        nome = projections.getNome();
        dataNascimento = projections.getDataNascimento();
        enderecoPrincipal.setCep(projections.getCep());
        enderecoPrincipal.setCidade(projections.getCidade());
        enderecoPrincipal.setLogradouro(projections.getLogradouro());
        enderecoPrincipal.setNumero(projections.getNumero());
    }

}
