package com.gestaopessoa.enderco.entities.PK;

import com.gestaopessoa.enderco.entities.Endereco;
import com.gestaopessoa.enderco.entities.Pessoa;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PessoaEnderecoPK {
    @OneToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;
}
