package com.gestaopessoa.enderco.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestaopessoa.enderco.DTO.EnderecoDTO;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "tb_endereco")
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    public Endereco(EnderecoDTO novoEndereco){
        logradouro = novoEndereco.getLogradouro();
        cep =  novoEndereco.getCep();
        numero = novoEndereco.getNumero();
        cidade = novoEndereco.getCidade();
    }
}
