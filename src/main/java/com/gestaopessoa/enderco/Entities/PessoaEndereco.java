package com.gestaopessoa.enderco.Entities;

import com.gestaopessoa.enderco.Entities.PK.PessoaEnderecoPK;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_pessoa_endereco")
public class PessoaEndereco {

    @EmbeddedId
    private PessoaEnderecoPK id = new PessoaEnderecoPK();
    public Pessoa getPessoa() {
        return id.getPessoa();
    }
    public void setPessoa(Pessoa pessoa){
        id.setPessoa(pessoa);
    }

    public Endereco getEndereco(){
        return id.getEndereco();
    }
    public void setEndereco(Endereco endereco){
        id.setEndereco(endereco);
    }
}
